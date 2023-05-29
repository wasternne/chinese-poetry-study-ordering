import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Library {
    JSONParser jsonParser = new JSONParser();
    Map<String, Author> authors = new HashMap<>();
    Set<Poem> poems = new HashSet<>();

    Library(Path basePath) {
        load(basePath);
    }

    public void load(Path basePath) {
        try (Stream<Path> files = Files.walk(basePath)) {
            files.forEach(f -> {
                if (f.toString().matches("\\.\\\\五代诗词\\\\huajianji\\\\huajianji-.*-juan.json")) {
                    loadPoems(f, Poem::parseHuaJianJi);
                } else if (f.toString().matches("\\.\\\\五代诗词\\\\nantang\\\\poetrys.json")) {
                    loadPoems(f, Poem::parseNanTang);
                } else if (f.toString().matches("\\.\\\\元曲\\\\yuanqu.json")) {
                    loadPoems(f, Poem::parseYuanQu);
                } else if (f.toString().matches("\\.\\\\全唐诗\\\\poet\\.song\\.\\d+\\.json")) {
                    loadPoems(f, Poem::parsePoetSong);
                } else if (f.toString().matches("\\.\\\\全唐诗\\\\poet\\.tang\\.\\d+\\.json")) {
                    loadPoems(f, Poem::parsePoetTang);
                } else if (f.toString().matches("\\.\\\\宋词\\\\ci\\.song\\.\\d+\\.json")) {
                    loadPoems(f, Poem::parseSongCi);
                } else if (f.toString().matches("\\.\\\\宋词\\\\ci\\.song\\.2019y\\.json")) { // Weird one
                    loadPoems(f, Poem::parseSongCi);
                } else if (f.toString().matches("\\.\\\\御定全唐詩\\\\json\\\\\\d+\\.json")) {
                    loadPoems(f, Poem::parseYuDingQuanTangShi);
                } else if (f.toString().matches("\\.\\\\曹操诗集\\\\caocao\\.json")) {
                    loadPoems(f, Poem::parseCaoCao);
                } else if (f.toString().matches("\\.\\\\楚辞\\\\chuci\\.json")) {
                    loadPoems(f, Poem::parseChuCi);
                } else if (f.toString().matches("\\.\\\\水墨唐诗\\\\shuimotangshi\\.json")) {
                    loadPoems(f, Poem::parseShuiMoTangShi);
                } else if (f.toString().matches("\\.\\\\纳兰性德\\\\纳兰性德诗集\\.json")) {
                    loadPoems(f, Poem::parseNaLanXingDe);
                } else if (f.toString().matches("\\.\\\\诗经\\\\shijing\\.json")) {
                    loadPoems(f, Poem::parseShiJing);
                } else {
                    // TODO Add 蒙学 files
                    System.out.println("Skipping: " + f);
                }
            });
            System.out.println("Total: " + poems.size() + " poems.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadPoems(Path f, Function<JSONObject, Poem> parser) {
        try (FileReader reader = new FileReader(f.toString())) {
            JSONArray aPoems = (JSONArray) jsonParser.parse(reader);
            Stream<JSONObject> s = aPoems.stream().filter(Objects::nonNull);
            List<Poem> poems = s.map(parser).toList();
            this.poems.addAll(poems);
            System.out.println("Parsing: " + f + ", added " + poems.size() + " poems.");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}