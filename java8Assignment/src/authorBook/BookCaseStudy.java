package authorBook;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class BookCaseStudy {

	private static List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(new Author("Rohit", "Singh", "India"),
				new Author("Paras", "Gupta", "India"));

		List<Author> authors2 = Arrays.asList(new Author("Steve", "Smith", "Australia"));

		List<Author> authors3 = Arrays.asList(new Author("Joe", "Smith", "UK"), new Author("James", "William", "USA"));

		books.add(new Book("Java", authors1, 401, Subject.JAVA, 2000, "1213"));
		books.add(new Book("Oracle", authors2, 479, Subject.ORACLE, 2007, "1218"));
		books.add(new Book("Dot Net Features", authors3, 600, Subject.DOT_NET, 2002, "1293"));

		books.add(new Book("Java 2", authors3, 301, Subject.JAVA, 2002, "1215"));
		books.add(new Book("Oracle 2", authors1, 579, Subject.ORACLE, 2008, "1219"));
		books.add(new Book("Dot Net Features 2", authors2, 800, Subject.DOT_NET, 2009, "1295"));

		return books;
	}

	public static void main(String[] args) {

		List<Book> books = getAllBooks();
		
		

		List<Book> booksWithMoreThan400Pages = books.stream().filter(e -> e.getPages() > 400)
				.collect(Collectors.toList());
//		booksWithMoreThan400Pages.stream().forEach(System.out::println);
		
		

		List<Book> javaBooksWithMoreThan400Pages = books.stream().filter(e -> e.getPages() > 400)
				.filter(e -> e.getSubject().equals(Subject.JAVA)).collect(Collectors.toList());
//		javaBooksWithMoreThan400Pages.stream().forEach(System.out::println);
		
		

		List<Book> longestBooks = books.stream().sorted((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()))
				.limit(3).collect(Collectors.toList());
//		longestBooks.stream().forEach(System.out::println);
		
		

		List<Book> longestBooksAfterFourth = books.stream()
				.sorted((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages())).skip(3).collect(Collectors.toList());
//		longestBooksAfterFourth.stream().forEach(System.out::println);
		
		

		List<Integer> allPublishingYears = books.stream().map(e -> e.getYear()).distinct().sorted()
				.collect(Collectors.toList());
//		allPublishingYears.stream().forEach(System.out::println);
		
		

		List<Author> allPublishingAuthors = books.stream().flatMap(b -> b.getAuthors().stream()).distinct()
				.collect(Collectors.toList());
//		allPublishingAuthors.stream().forEach(System.out::println);
		
		

		List<String> originCountriesOfAuthors = books.stream().flatMap(b -> b.getAuthors().stream()).distinct()
				.map(a -> a.getCountry()).distinct().collect(Collectors.toList());
//		originCountriesOfAuthors.stream().forEach(System.out::println);
		
		

		Optional<Book> mostRecentlyPublishedBook = books.stream().max(Comparator.comparing(Book::getYear));
//		System.out.println(mostRecentlyPublishedBook.orElseGet(()-> new Book()));
		
		

		boolean ifAllBooksHaveMoreThanOneAuthor = books.stream().allMatch(b -> b.getAuthors().size() > 1);
//		System.out.println(ifAllBooksHaveMoreThanOneAuthor);
		
		

		Optional<Book> anyOneBookWithMoreThanOneAuthor = books.stream().filter(b -> b.getAuthors().size() > 1)
				.findAny();
//		if(anyOneBookWithMoreThanOneAuthor.isPresent()) {
//			System.out.println(anyOneBookWithMoreThanOneAuthor.get());			
//		}
//		else {
//			System.out.println("Not Found");
//		}
		
		
		
		Integer noOfPagesSum1 = books.stream().map(b->b.getPages()).reduce(0, (a,b)->a+b);
		//or
		Integer noOfPagesSum2 = books.stream().mapToInt(Book::getPages).sum();
//		System.out.println(noOfPagesSum1);
		
		


		OptionalInt noOfPages = books.stream().mapToInt(b->b.getPages()).reduce(Integer::max);
		//or
		OptionalInt noOfPages2 = books.stream().mapToInt(b->b.getPages()).max();
//		System.out.println(noOfPages2.orElseGet(()-> 0));
		
		
		
		Double avgPages = books.stream().collect(Collectors.averagingDouble(Book::getPages));
		//or
		OptionalDouble avgOfPages = books.stream().mapToInt(b->b.getPages()).average();
//		System.out.println(avgOfPages.orElseGet(()-> 0f));
		
		
		
		List<String> allTitles = books.stream().map(b->b.getTitle()).distinct().collect(Collectors.toList());
//		allTitles.stream().forEach(System.out::println);
		
		
		
		OptionalInt maxNoOfAuthors = books.stream().mapToInt(b->b.getAuthors().size()).max();
//		System.out.println(maxNoOfAuthors.orElse(-1));
		
		
		
		Map<Integer, List<Book>> mapOfBooksByYear = books.stream().collect(Collectors.groupingBy(Book::getYear));
//		for(Entry<Integer, List<Book>> e : mapOfBooksByYear.entrySet()) {
//			System.out.println(e.getKey() + " : "+e.getValue());
//		}
		
		
		
		Map<Integer, Map<Subject, List<Book>>> BooksPublishedPerYearPerSubject = books.stream().collect(Collectors.groupingBy(Book::getYear,Collectors.groupingBy(Book::getSubject)));
//		for(Entry<Integer, Map<Subject, List<Book>>> e : BooksPublishedPerYearPerSubject.entrySet()) {
//			System.out.println(e.getKey());
//			for(Entry<Subject,List<Book>> b : e.getValue().entrySet()) {
//				System.out.println(b.getKey() + " : " + b.getValue());
//			}
//		}
//		
		
		
		
		Map<Integer, Long> BooksCountPerYear = books.stream().collect(Collectors.groupingBy(Book::getYear, Collectors.counting()));
//		for(Entry<Integer, Long> e : BooksCountPerYear.entrySet()) {
//			System.out.println(e.getKey() + " : "+e.getValue());
//		}
		
		
		
	}
}
