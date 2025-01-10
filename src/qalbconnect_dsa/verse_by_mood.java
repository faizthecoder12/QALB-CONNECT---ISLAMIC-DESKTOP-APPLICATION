/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qalbconnect_dsa;

/**
 *
 * @author USER
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class verse_by_mood {

    public static final Map<String, List<MoodVerse>> moodVerses = new HashMap<>();

    // Inner class to represent a verse
    public static class MoodVerse {
        String verse;
        String reference;

        MoodVerse(String verse, String reference) {
            this.verse = verse;
            this.reference = reference;
        }
    }

    static {
        // Adding moods and verses
        moodVerses.put("Happiness", new ArrayList<>());
        moodVerses.get("Happiness").add(new MoodVerse(
            "Indeed, those who believe and do righteous deeds - the Most Merciful will extend to them [His] affection.",
            "Surah Maryam (19:96)"
                
        ));

        moodVerses.get("Happiness").add(new MoodVerse(
            "And We will surely reward those who were patient with the best reward for what they used to do.",
            "Surah Az-Zumar (39:10)"
        ));

        moodVerses.put("Sadness", new ArrayList<>());
        moodVerses.get("Sadness").add(new MoodVerse(
            "Do not lose hope in the mercy of Allah. Indeed, Allah forgives all sins.",
            "Surah Az-Zumar (39:53)"
        ));
        moodVerses.get("Sadness").add(new MoodVerse(
            "And rely upon Allah; and sufficient is Allah as Disposer of affairs.",
            "Surah Al-Ahzab (33:3)"
        ));


        moodVerses.put("Anger", new ArrayList<>());
        moodVerses.get("Anger").add(new MoodVerse(
            "And those who suppress anger and pardon people - indeed, Allah loves the doers of good.",
            "Surah Aal-E-Imran (3:134)"
        ));
        moodVerses.get("Anger").add(new MoodVerse(
            "Repel [evil] by that [deed] which is better; and thereupon the one whom between you and him is enmity [will become] as though he was a devoted friend.",
            "Surah Fussilat (41:34)"
        ));


        moodVerses.put("Fear", new ArrayList<>());
        moodVerses.get("Fear").add(new MoodVerse(
            "Indeed, Allah is with those who fear Him and those who are doers of good.",
            "Surah An-Nahl (16:128)"
        ));
        moodVerses.get("Fear").add(new MoodVerse(
            "And whoever fears Allah - He will make for him a way out and provide for him from where he does not expect.",
            "Surah At-Talaq (65:2-3)"
        ));


        moodVerses.put("Excitement", new ArrayList<>());
        moodVerses.get("Excitement").add(new MoodVerse(
            "So remember Me; I will remember you.",
            "Surah Al-Baqarah (2:152)"
        ));
        moodVerses.get("Excitement").add(new MoodVerse(
            "And when your Lord proclaimed: 'If you are grateful, I will surely increase you [in favor].'",
            "Surah Ibrahim (14:7)"
        ));


        moodVerses.put("Stress", new ArrayList<>());
        moodVerses.get("Stress").add(new MoodVerse(
            "Allah does not burden a soul beyond that it can bear.",
            "Surah Al-Baqarah (2:286)"
        ));
        moodVerses.get("Stress").add(new MoodVerse(
            "And whoever puts their trust in Allah - then He is sufficient for him.",
            "Surah At-Talaq (65:3)"
        ));


        moodVerses.put("Love", new ArrayList<>());
        moodVerses.get("Love").add(new MoodVerse(
            "Indeed, those who have believed and done righteous deeds - the Most Merciful will appoint for them affection.",
            "Surah Maryam (19:96)"
        ));
        moodVerses.get("Love").add(new MoodVerse(
            "And He placed between you affection and mercy. Indeed in that are signs for a people who give thought.",
            "Surah Ar-Rum (30:21)"
        ));


        moodVerses.put("Hope", new ArrayList<>());
        moodVerses.get("Hope").add(new MoodVerse(
            "Indeed, with hardship [will be] ease.",
            "Surah Ash-Sharh (94:6)"
        ));
        moodVerses.get("Hope").add(new MoodVerse(
            "And whoever fears Allah - He will make for him a way out.",
            "Surah At-Talaq (65:2)"
        ));


        moodVerses.put("Anxiety", new ArrayList<>());
        moodVerses.get("Anxiety").add(new MoodVerse(
            "Unquestionably, by the remembrance of Allah hearts are assured.",
            "Surah Ar-Ra’d (13:28)"
        ));
        moodVerses.get("Anxiety").add(new MoodVerse(
            "And be patient, for indeed, Allah does not allow the reward of those who do good to be lost.",
            "Surah Hud (11:115)"
        ));


        moodVerses.put("Curiosity", new ArrayList<>());
        moodVerses.get("Curiosity").add(new MoodVerse(
            "And He taught Adam the names - all of them.",
            "Surah Al-Baqarah (2:31)"
        ));
        moodVerses.get("Curiosity").add(new MoodVerse(
            "And He has taught man that which he knew not.",
            "Surah Al-Alaq (96:5)"
        ));


        moodVerses.put("Jealousy", new ArrayList<>());
        moodVerses.get("Jealousy").add(new MoodVerse(
            "And do not wish for that by which Allah has made some of you exceed others.",
            "Surah An-Nisa (4:32)"
        ));
        moodVerses.get("Jealousy").add(new MoodVerse(
            "It is We who have apportioned among them their livelihood in the life of this world.",
            "Surah Az-Zukhruf (43:32)"
        ));


        moodVerses.put("Pride", new ArrayList<>());
        moodVerses.get("Pride").add(new MoodVerse(
            "Indeed, Allah does not like the arrogant.",
            "Surah An-Nahl (16:23)"
        ));
        moodVerses.get("Pride").add(new MoodVerse(
            "And do not walk upon the earth exultantly. Indeed, you will never tear the earth [apart], and you will never reach the mountains in height.",
            "Surah Al-Isra (17:37)"
        ));

    }

    public MoodVerse getRandomVerseForMood(String mood) {
        List<MoodVerse> verses = moodVerses.get(mood);
        if (verses != null && !verses.isEmpty()) {
            Random random = new Random();
            return verses.get(random.nextInt(verses.size()));
        }
        return null;
    }

    public void displayVerseForMood(String mood) {
        MoodVerse verse = getRandomVerseForMood(mood);
        if (verse != null) {
            System.out.println("Mood: " + mood);
            System.out.println("Verse: " + verse.verse);
            System.out.println("Reference: " + verse.reference);
        } else {
            System.out.println("No verses found for the mood: " + mood);
        }
    }

    public void displayAvailableMoods() {
        System.out.println("Available moods:");
        for (String mood : moodVerses.keySet()) {
            System.out.println("- " + mood);
        }
    }

    public static void main(String[] args) {
        verse_by_mood verseManager = new verse_by_mood();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            verseManager.displayAvailableMoods();
            System.out.println("Enter a mood to get a verse (or type 'exit' to quit):");
            String mood = scanner.nextLine();

            if (mood.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            verseManager.displayVerseForMood(mood);
            System.out.println(); // Add a blank line for better readability
        }

        scanner.close();
    }
}