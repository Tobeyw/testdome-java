public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }
    //快慢指针
    public boolean isInRepeatingPlaylist() {
        Song slowPointer = this;
        Song fastPointer = this;

        while (fastPointer != null && fastPointer.nextSong != null) {
            slowPointer = slowPointer.nextSong;            
            fastPointer = fastPointer.nextSong.nextSong;    

            if (slowPointer == fastPointer) {
                return true;  
            }
        }
        return false;  
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}