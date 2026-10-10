Question: 5 - Music Playlist — Singly Linked List
Scenario
A music application maintains songs in a playlist. Users can add songs to the playlist and 
remove a song when they no longer want it.
Question
Implement a linked list playlist that supports:
1. Adding songs. 
2. Removing a song. 
3. Displaying the playlist

import java.util.Scanner;

class Node {
    String song;
    Node next;

    Node(String song) {
        this.song = song;
        this.next = null;
    }
}

public class Main {
    static Node head = null;

    static void addSong(String song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    static void removeSong(String song) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        if (head.song.equalsIgnoreCase(song)) {
            head = head.next;
            System.out.println("Song removed: " + song);
            return;
        }

        Node temp = head;
        while (temp.next != null &&
               !temp.next.song.equalsIgnoreCase(song)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Song removed: " + song);
        } else {
            System.out.println("Song not found.");
        }
    }

    static void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        Node temp = head;
        System.out.println("Music Playlist:");
        while (temp != null) {
            System.out.println(temp.song);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of songs: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song name: ");
            addSong(sc.nextLine());
        }

        displayPlaylist();

        System.out.print("Enter song to remove: ");
        String song = sc.nextLine();

        removeSong(song);
        displayPlaylist();

        sc.close();
    }
}

Enter number of songs: 3
Enter song name: Believer
Enter song name: Perfect
Enter song name: Memories
Enter song to remove: Perfect

Music Playlist:
Believer
Perfect
Memories
Song removed: Perfect
Music Playlist:
Believer
Memories

