import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    public static List<Livre> chargerCatalogue(String chemin) {
        try (Reader reader = new FileReader(chemin)) {
            Type livreListType = new TypeToken<List<Livre>>() {}.getType();
            return new Gson().fromJson(reader, livreListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void exporterCatalogue(List<Livre> livres, String chemin) {
        try (Writer writer = new FileWriter(chemin)) {
            new Gson().toJson(livres, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}