package LibrarySystem;

public interface LibraryServiceInterface {
    void addAuthor();
    void addAsset();
    void adduser();
    void borrowAsset();
    void returnAsset();
    void showAvailableBooks();//list available books
    void showBorrowedAssetsByUser(int id);//assets borrowed by a user
    void showAssetsAuthoredByAuthor(String authorName);
    void showOverdueAssets();
    void printAuthors();
    void printUsers();
    void printAssets();
}
