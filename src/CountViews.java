class Video {
    String name;
    int uniqueViews;

    public Video(String name, int uniqueViews) {
        this.name = name;
        this.uniqueViews = uniqueViews;
    }
}

class Viewer {
    String username;
    Video[] watchedVideos;

    public Viewer(String username,Video[] watchedVideos) {
        this.username = username;
        this.watchedVideos = watchedVideos;
    }
}

public class CountViews {
    public static int countViews(Viewer[] viewers,String videoName) {
        int count = 0;

        for (Viewer viewer : viewers) {
            // 遍历每个 Viewer 的 watchedVideos
            for (Video video : viewer.watchedVideos) {
                if (video.name.equals(videoName)) {
                    count++;
                    break; // 跳出内层循环，因为一个 viewer 只算一次
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 创建示例 Video 对象
        Video soccer = new Video("Soccer", 500);
        Video basketball = new Video("Basketball", 1000);

        // 创建示例 Viewer 对象
        Viewer viewer1 = new Viewer("Dave",new Video[]{soccer, basketball});
        Viewer viewer2 = new Viewer("John", new Video[]{basketball});
        Viewer viewer3 = new Viewer("Alice",new Video[]{soccer});

        // Viewer 数组
        Viewer[] viewers = {viewer1,viewer2,viewer3};

        // 调用 countViews 方法
        int result = countViews(viewers, "Soccer");
        System.out.println("Number of viewers who watched 'Soccer': " + result);
    }
}
