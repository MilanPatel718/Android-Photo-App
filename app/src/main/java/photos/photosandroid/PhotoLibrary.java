package photos.photosandroid;
        import java.io.*;
        import java.util.ArrayList;
/**
 *
 * @author Baljit Kaur
 * @author Milan Patel
 *
 * Represents a photo library containing multiple albums
 * Serializes and saves user data
 */
public class PhotoLibrary implements Serializable{
    private static final long serialVersionUID = 1L;
    ArrayList<Album> Albums;
    public static final String storeFile = "library.bin";

    /**
     * Initializes object with an admin and empty list of users
     */
    public PhotoLibrary(){
            Albums=new ArrayList<>();
    }

    /**
     * Writes to binary file to save PhotoLibrary instance and album data
     * @param photoLib instance of PhotoLibrary
     * @throws IOException
     */
    public static void writeApp(PhotoLibrary photoLib) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(storeFile));
        oos.writeObject(photoLib);
        oos.close();
    }

    /**
     * Reads from binary file and retrieves saved date
     * @return PhotoLibrary instance
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static PhotoLibrary readApp() throws IOException, ClassNotFoundException {
        File fs = new File(storeFile);
        if(fs.length() == 0){
            return new PhotoLibrary();
        }
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(storeFile));
        PhotoLibrary photoLib = (PhotoLibrary)ois.readObject();
        ois.close();
        return photoLib;
    }

}
