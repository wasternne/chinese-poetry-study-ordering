import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class Poem {

    private String id;
    private Integer number;
    private String title;
    private String biography;
    private String volume;
    private String chapter;
    private String section;
    private String prologue;
    private String[] paragraphs;
    private String author;
    private String rhythmic;
    private String[] notes;
    private String dynasty;

    public Poem(String id, String title, String[] paragraphs, String author, String rhythmic, String[] notes
            , String dynasty, Integer number, String biography, String volume, String section, String prologue
            , String chapter) {
        this.id = id;
        this.number = number;
        this.biography = biography;
        this.title = title;
        this.paragraphs = paragraphs;
        this.author = author;
        this.rhythmic = rhythmic;
        this.notes = notes;
        this.dynasty = dynasty;
        this.volume = volume;
        this.section = section;
        this.chapter = chapter;
        this.prologue = prologue;
    }

    public static Poem parseHuaJianJi(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = o.get("rhythmic").toString();
        String dynasty = ""; // TODO Find info
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = parseStringArray((JSONArray) o.get("notes"));
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseNanTang(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = o.get("rhythmic").toString();
        String dynasty = ""; // TODO Find info
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = parseStringArray((JSONArray) o.get("notes"));
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseYuanQu(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = null;
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = o.get("dynasty").toString();
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parsePoetSong(JSONObject o) {
        String id = o.get("id").toString();
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "song"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parsePoetTang(JSONObject o) {
        String id = o.get("id").toString();
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "tang"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseSongCi(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = null;
        String author = o.get("author").toString();
        String rhythmic = o.get("rhythmic").toString();
        String dynasty = "song"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseYuDingQuanTangShi(JSONObject o) {
        String id = null;
        Integer number = Integer.valueOf(o.get("no#").toString());
        String biography = o.get("biography").toString();
        String volume = o.get("volume").toString();
        String section = null;
        String chapter = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "tang"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = parseStringArray((JSONArray) o.get("notes"));
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseCaoCao(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = "曹操";
        String rhythmic = null;
        String dynasty = "han"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("paragraphs"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseChuCi(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = o.get("section").toString();
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "chu"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("content")); // TODO What's the difference between paragraphs vs content?
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseNaLanXingDe(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = null;
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "qing"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("para"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseShiJing(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = o.get("chapter").toString();
        String section = o.get("section").toString();
        String prologue = null;
        String title = o.get("title").toString();
        String author = null;
        String rhythmic = null;
        String dynasty = "zhou"; // TODO Make sure
        String[] paragraphs = parseStringArray((JSONArray) o.get("content"));
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    public static Poem parseShuiMoTangShi(JSONObject o) {
        String id = null;
        Integer number = null;
        String biography = null;
        String volume = null;
        String chapter = null;
        String section = null;
        String prologue = o.get("prologue").toString();
        String title = o.get("title").toString();
        String author = o.get("author").toString();
        String rhythmic = null;
        String dynasty = "tang"; // TODO Make sure
        JSONArray aParagraphs = (JSONArray) o.get("paragraphs");
        if (aParagraphs == null) return null; // There's a "poem" w/o this part.
        String[] paragraphs = parseStringArray(aParagraphs);
        String[] notes = null;
        return new Poem(id, title, paragraphs, author, rhythmic, notes, dynasty, number, biography, volume, section, prologue, chapter);
    }

    private static String[] parseStringArray(JSONArray a) {
        List<String> l = (List<String>) a.stream().collect(Collectors.toList());
        return l.toArray(new String[] {});
    }
}
