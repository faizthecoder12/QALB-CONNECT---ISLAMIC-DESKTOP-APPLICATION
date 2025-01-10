package qalbconnect_dsa;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class namesofAllah {

    // Inner class to represent a Name of Allah
    public static class NameOfAllah {
        String arabicName;
        String englishTranslation;

        NameOfAllah(String arabicName, String englishTranslation) {
            this.arabicName = arabicName;
            this.englishTranslation = englishTranslation;
        }

        @Override
        public String toString() {
            return arabicName + " - " + englishTranslation;
        }
    }

    // List to store the 99 Names of Allah
    public static final List<NameOfAllah> namesOfAllah = new ArrayList<>();

    static {
        // Populate the list with the 99 Names of Allah
        namesOfAllah.add(new NameOfAllah("ٱلرَّحْمَـٰنُ", "Ar-Rahman (The Most Gracious)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّحِيمُ", "Ar-Raheem (The Most Merciful)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمَلِكُ", "Al-Malik (The King)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقُدُّوسُ", "Al-Quddus (The Holy)"));
        namesOfAllah.add(new NameOfAllah("ٱلسَّلَامُ", "As-Salam (The Source of Peace)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُؤْمِنُ", "Al-Mu'min (The Guardian of Faith)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُهَيْمِنُ", "Al-Muhaymin (The Protector)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَزِيزُ", "Al-Aziz (The Mighty)"));
        namesOfAllah.add(new NameOfAllah("ٱلْجَبَّارُ", "Al-Jabbar (The Compeller)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُتَكَبِّرُ", "Al-Mutakabbir (The Greatest)"));
        namesOfAllah.add(new NameOfAllah("ٱلْخَالِقُ", "Al-Khaliq (The Creator)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَارِئُ", "Al-Bari' (The Evolver)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُصَوِّرُ", "Al-Musawwir (The Fashioner)"));
        namesOfAllah.add(new NameOfAllah("ٱلْغَفَّارُ", "Al-Ghaffar (The Forgiver)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقَهَّارُ", "Al-Qahhar (The Subduer)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَهَّابُ", "Al-Wahhab (The Bestower)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّزَّاقُ", "Ar-Razzaq (The Provider)"));
        namesOfAllah.add(new NameOfAllah("ٱلْفَتَّاحُ", "Al-Fattah (The Opener)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَلِيمُ", "Al-'Alim (The All-Knowing)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقَابِضُ", "Al-Qabid (The Constrictor)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَاسِطُ", "Al-Basit (The Expander)"));
        namesOfAllah.add(new NameOfAllah("ٱلْخَافِضُ", "Al-Khafid (The Abaser)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّافِعُ", "Ar-Rafi' (The Exalter)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُعِزُّ", "Al-Mu'izz (The Bestower of Honors)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُذِلُّ", "Al-Mudhill (The Humiliator)"));
        namesOfAllah.add(new NameOfAllah("ٱلسَّمِيعُ", "As-Sami' (The All-Hearing)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَصِيرُ", "Al-Basir (The All-Seeing)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَكَمُ", "Al-Hakam (The Judge)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَدْلُ", "Al-'Adl (The Just)"));
        namesOfAllah.add(new NameOfAllah("ٱللَّطِيفُ", "Al-Latif (The Subtle)"));
        namesOfAllah.add(new NameOfAllah("ٱلْخَبِيرُ", "Al-Khabir (The Aware)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَلِيمُ", "Al-Halim (The Forbearing)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَظِيمُ", "Al-'Azim (The Magnificent)"));
        namesOfAllah.add(new NameOfAllah("ٱلْغَفُورُ", "Al-Ghafur (The Forgiving)"));
        namesOfAllah.add(new NameOfAllah("ٱلشَّكُورُ", "Ash-Shakur (The Appreciative)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَلِيُّ", "Al-'Ali (The Most High)"));
        namesOfAllah.add(new NameOfAllah("ٱلْكَبِيرُ", "Al-Kabir (The Greatest)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَفِيظُ", "Al-Hafiz (The Preserver)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُقِيتُ", "Al-Muqit (The Nourisher)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَسِيبُ", "Al-Hasib (The Reckoner)"));
        namesOfAllah.add(new NameOfAllah("ٱلْجَلِيلُ", "Al-Jalil (The Majestic)"));
        namesOfAllah.add(new NameOfAllah("ٱلْكَرِيمُ", "Al-Karim (The Generous)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّقِيبُ", "Ar-Raqib (The Watchful)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُجِيبُ", "Al-Mujib (The Responsive)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَاسِعُ", "Al-Wasi' (The All-Encompassing)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَكِيمُ", "Al-Hakim (The Wise)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَدُودُ", "Al-Wadud (The Loving)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمَجِيدُ", "Al-Majid (The Most Glorious)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَاعِثُ", "Al-Ba'ith (The Resurrector)"));
        namesOfAllah.add(new NameOfAllah("ٱلشَّهِيدُ", "Ash-Shahid (The Witness)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَقُّ", "Al-Haqq (The Truth)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَكِيلُ", "Al-Wakil (The Trustee)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقَوِيُّ", "Al-Qawi (The Strong)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمَتِينُ", "Al-Matin (The Firm)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَلِيُّ", "Al-Wali (The Friend)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَمِيدُ", "Al-Hamid (The Praiseworthy)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُحْصِيُ", "Al-Muhsi (The Counter)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُبْدِئُ", "Al-Mubdi' (The Originator)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُعِيدُ", "Al-Mu'id (The Restorer)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُحْيِى", "Al-Muhyi (The Giver of Life)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُمِيتُ", "Al-Mumit (The Taker of Life)"));
        namesOfAllah.add(new NameOfAllah("ٱلْحَىُّ", "Al-Hayy (The Ever Living)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقَيُّومُ", "Al-Qayyum (The Self-Subsisting)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَاجِدُ", "Al-Wajid (The Finder)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمَاجِدُ", "Al-Majid (The Noble)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَاحِدُ", "Al-Wahid (The One)"));
        namesOfAllah.add(new NameOfAllah("ٱلْأَحَدُ", "Al-Ahad (The Unique)"));
        namesOfAllah.add(new NameOfAllah("ٱلصَّمَدُ", "As-Samad (The Eternal)"));
        namesOfAllah.add(new NameOfAllah("ٱلْقَادِرُ", "Al-Qadir (The Capable)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُقْتَدِرُ", "Al-Muqtadir (The Powerful)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُقَدِّمُ", "Al-Muqaddim (The Expediter)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُؤَخِّرُ", "Al-Mu'akhkhir (The Delayer)"));
        namesOfAllah.add(new NameOfAllah("ٱلْأَوَّلُ", "Al-Awwal (The First)"));
        namesOfAllah.add(new NameOfAllah("ٱلْآخِرُ", "Al-Akhir (The Last)"));
        namesOfAllah.add(new NameOfAllah("ٱلظَّاهِرُ", "Az-Zahir (The Manifest)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَاطِنُ", "Al-Batin (The Hidden)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَالِي", "Al-Wali (The Governor)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُتَعَالِي", "Al-Muta'ali (The Most Exalted)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَرُّ", "Al-Barr (The Source of All Goodness)"));
        namesOfAllah.add(new NameOfAllah("ٱلتَّوَّابُ", "At-Tawwab (The Acceptor of Repentance)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُنْتَقِمُ", "Al-Muntaqim (The Avenger)"));
        namesOfAllah.add(new NameOfAllah("ٱلْعَفُوُّ", "Al-'Afuw (The Pardoner)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّؤُفُ", "Ar-Ra'uf (The Clement)"));
        namesOfAllah.add(new NameOfAllah("مَالِكُ ٱلْمُلْكِ", "Malik-ul-Mulk (The Owner of All)"));
        namesOfAllah.add(new NameOfAllah("ذُو ٱلْجَلَالِ وَٱلْإِكْرَامِ", "Dhul-Jalali-wal-Ikram (The Lord of Majesty and Bounty)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُقْسِطُ", "Al-Muqsit (The Equitable)"));
        namesOfAllah.add(new NameOfAllah("ٱلْجَامِعُ", "Al-Jami' (The Gatherer)"));
        namesOfAllah.add(new NameOfAllah("ٱلْغَنِيُّ", "Al-Ghani (The Self-Sufficient)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمُغْنِي", "Al-Mughni (The Enricher)"));
        namesOfAllah.add(new NameOfAllah("ٱلْمَانِعُ", "Al-Mani' (The Preventer)"));
        namesOfAllah.add(new NameOfAllah("ٱلضَّارُّ", "Ad-Darr (The Distressor)"));
        namesOfAllah.add(new NameOfAllah("ٱلنَّافِعُ", "An-Nafi' (The Benefiter)"));
        namesOfAllah.add(new NameOfAllah("ٱلنُّورُ", "An-Nur (The Light)"));
        namesOfAllah.add(new NameOfAllah("ٱلْهَادِي", "Al-Hadi (The Guide)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَدِيعُ", "Al-Badi' (The Originator)"));
        namesOfAllah.add(new NameOfAllah("ٱلْبَاقِي", "Al-Baqi (The Everlasting)"));
        namesOfAllah.add(new NameOfAllah("ٱلْوَارِثُ", "Al-Warith (The Inheritor)"));
        namesOfAllah.add(new NameOfAllah("ٱلرَّشِيدُ", "Ar-Rashid (The Guide to the Right Path)"));
        namesOfAllah.add(new NameOfAllah("ٱلصَّبُورُ", "As-Sabur (The Patient )"));
        
        // Add remaining names here...
    }

    // Method to display all names
    public void displayAllNames() {
        System.out.println("99 Names of Allah:");
        for (int i = 0; i < namesOfAllah.size(); i++) {
            System.out.println((i + 1) + ". " + namesOfAllah.get(i));
        }
    }

    // Method to search for a name by index
    public void displayNameByIndex(int index) {
        if (index >= 1 && index <= namesOfAllah.size()) {
            System.out.println("Name " + index + ": " + namesOfAllah.get(index - 1));
        } else {
            System.out.println("Invalid index. Please enter a number between 1 and " + namesOfAllah.size() + ".");
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Set the output stream to UTF-8
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        namesofAllah app = new namesofAllah();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Display all 99 Names of Allah");
            System.out.println("2. Display a specific Name by index");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    app.displayAllNames();
                    break;
                case 2:
                    System.out.print("Enter the index (1-99): ");
                    int index = scanner.nextInt();
                    app.displayNameByIndex(index);
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
