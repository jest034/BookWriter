import java.io.IOException;

public class BookTester {

	public static void main(String[] args) throws IOException {
		inputText it = new inputText ("thegreatgatsby.txt");
		it.writeBook("The Great Gatsby", 100000);
		it.toStrng();
		
	}

}

