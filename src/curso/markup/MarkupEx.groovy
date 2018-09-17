package curso.markup

import groovy.transform.Canonical
import groovy.xml.MarkupBuilder

new MarkupBuilder().books {
    book (isbn:'978-1935182443') {
        title 'Groovy in Action 2nd Edition'
        author 'Dierk Koenig'
        price 50.58
    }
    book (isbn:'978-1935182948') {
        title 'Making Java Groovy'
        author 'Ken Kousen'
        price 33.96
    }
    book (isbn:'978-1937785307') {
        title 'Programming Groovy 2: Dynamic Productivity for the Java Developer'
        author 'Venkat Subramaniam'
        price 28.92
    }
}

@Canonical
class Book {
    String isbn
    String title
    String author
    Number price
}

def books = [
        new Book('978-1935182443', 'Groovy in Action 2nd Edition', 'Dierk Koenig', 50.58),
        new Book('978-1935182948', 'Making Java Groovy', 'Ken Kousen', 33.96),
        new Book('978-1937785307', 'Programming Groovy 2: Dynamic Productivity for the Java Developer', 'Venkat Subramaniam', 28.92)
]

FileWriter writer = new FileWriter('books.html')
new MarkupBuilder(writer).html {
    head {
        title 'Pagina Exercício Groovy MarkupBulder'
    }
    body {
        h2 'Livros recomendados no curso'
        table (border: 1) {
            tr {
                th 'ISBN'
                th 'Title'
                th 'Author'
                th 'Price'
            }
            books.each { book ->
                tr {
                    td book.isbn
                    td book.title
                    td book.author
                    td book.price
                }
            }
        }
    }
}