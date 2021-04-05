package com.example.test.data


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.test.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith (AndroidJUnit4 :: class)
@SmallTest

class DaoTestAndroid
{

    private lateinit var itemData : ItemDatabase
    private lateinit var dao: Dao

   @Before
   fun setupTest ()
   {
    itemData = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), ItemDatabase::class.java
    ).allowMainThreadQueries().build()

      dao = itemData.dao()
   }


    /*
    Executes a testBody inside an immediate execution dispatcher.
    This is similar to runBlocking but it will immediately progress past delays and into launch and async blocks.
    You can use this to write tests that execute in the presence of calls to delay without causing your test to take extra time.
     */

    @Test
    fun InsertItem_ToDatabse_Test () = runBlockingTest {
        val item = Item("name", 10, 10f, "www.image-url.com", 1)
        dao.insertItem(item)

        val viewAllItem = dao.observeAllItems().getOrAwaitValue()

        assertThat(viewAllItem).contains(item)

    }


    @Test
    fun DeleteItem_ToDatabse_Test () = runBlockingTest {
        val item = Item("name", 1, 1f, "www.imageurl.com", 2)
        dao.insertItem(item)
        dao.deleteItem(item)

        val  viewAllItem = dao.observeAllItems().getOrAwaitValue()
        assertThat(viewAllItem).doesNotContain(item)
    }


     @Test
     fun TotalPrice_Test () = runBlockingTest{
         val item1 = Item("name", 10, 10f, "www.image-url.com", 1)
         val item2 = Item("name", 1, 1f, "www.imageurl.com", 2)
         val item3 = Item("name", 100, 100f, "www.image-url.com", 3)

         dao.insertItem(item1)
         dao.insertItem(item2)
         dao.insertItem(item3)


         val viewPriceOfAllItem = dao.observeTotalPrice().getOrAwaitValue()
         assertThat(viewPriceOfAllItem).isEqualTo(10 * 10f + 1 * 1f + 100 * 100f)
     }

    @After
    fun tearDown ()
    {
        itemData.close()
    }
}