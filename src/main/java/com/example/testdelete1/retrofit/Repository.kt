package com.example.bottomnewbest.retrofit



class Repository(val instance:ApiService) {

      fun getBooks()
    = instance.getBooksByCategory(2L) //TO-DO to pass the id dynamically
 fun getBestBooks()
    = instance.getBestBooksByCategoryId(2L) //TO-DO to pass the id dynamically

 fun getNewBooks()
    = instance.getNewBooksByCategoryId(2L) //TO-DO to pass the id dynamically

 fun searchAllBooks(text:String)
    = instance.searchByText(text) //TO-DO to pass the id dynamically


}