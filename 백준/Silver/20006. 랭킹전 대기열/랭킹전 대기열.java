import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Room {
        int minLevel;
        int maxLevel;
        List<String[]> players;

        public Room (int minLevel, int maxLevel, String[] player) {
            this.minLevel = minLevel;
            this.maxLevel = maxLevel;
            this.players = new ArrayList<>();
            this.players.add(player);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());

            String l = st.nextToken();
            int level = Integer.parseInt(l);
            String n = st.nextToken();

            boolean isIn = false;

            for (Room r : rooms) {
                if (r.players.size() == m) {
                    continue;
                }

                if (level >= r.minLevel && level <= r.maxLevel) {
                    r.players.add(new String[]{l, n});
                    isIn = true;
                    break;
                }
            }

            if (!isIn) {
                rooms.add(new Room(level - 10, level + 10, new String[]{l, n}));
            }
        }

        for (Room r : rooms) {
            if (r.players.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            Collections.sort(r.players, (a, b) -> {
                return a[1].compareTo(b[1]);
            });

            for (String[] s : r.players) {
                sb.append(s[0]).append(" ").append(s[1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}