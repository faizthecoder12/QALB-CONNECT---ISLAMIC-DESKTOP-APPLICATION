package qalbconnect_dsa;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class storiesofprophets {
    // Simulated database of prophet stories
    public static final Map<String, String> prophetStories = new HashMap<>();

    static {
        // Initializing prophet stories
        prophetStories.put("Hazrat Adam (A.S)", "Hazrat Adam (A.S) was the first prophet and the first human created by Allah. He was made from clay, and Allah breathed life into him. Allah granted him immense knowledge and made him superior to the angels, who were ordered to bow before him. Iblis (Satan) refused out of arrogance and was cast out of paradise. Hazrat Adam (A.S) and his wife Hawwa (Eve) lived in Jannah (paradise) but were deceived by Iblis into eating from the forbidden tree, which led to their descent to earth as a test. Allah forgave them, and Hazrat Adam (A.S) became the first messenger to guide humanity.\nHazrat Adam (A.S) taught people about worshipping Allah and living righteously. He emphasized gratitude, patience, and seeking forgiveness. His story reminds us of Allah's mercy and the importance of repentance after mistakes. Hazrat Adam (A.S) lived for many years and had several children, laying the foundation for the human race. His life serves as a lesson about obeying Allah and resisting the whispers of Satan.");
        prophetStories.put("Hazrat Nuh (A.S)", "Hazrat Nuh (A.S) was a prophet sent to guide his people, who had strayed into idol worship and sin. He preached for 950 years, calling them to the worship of Allah alone, but most of them mocked and rejected him. Despite his patience and persistent efforts, only a few people believed in his message. Allah commanded Hazrat Nuh (A.S) to build an ark, as a great flood was to come as punishment for the disbelievers. The ark carried the believers and pairs of animals, saving them from the devastating flood.\nThe story of Hazrat Nuh (A.S) is a powerful reminder of perseverance and reliance on Allah. It teaches the consequences of rejecting divine guidance and the importance of faith and obedience. After the flood, the believers repopulated the earth, and Hazrat Nuh (A.S)'s mission became a symbol of unwavering devotion to Allah despite opposition.");
        prophetStories.put("Hazrat Ibrahim (A.S)", "Hazrat Ibrahim (A.S), also known as Khalilullah (Friend of Allah), is one of the greatest prophets in Islam. He was born into a community of idol worshippers but rejected idolatry and recognized the oneness of Allah. He preached against idol worship, even challenging his people and the king, Nimrod, to acknowledge Allah’s greatness. When he destroyed the idols in the temple to prove their inability to protect themselves, he was thrown into a blazing fire, but Allah saved him by making the fire cool and harmless.\nHazrat Ibrahim (A.S) is known for his ultimate act of submission when he was commanded to sacrifice his beloved son, Hazrat Ismail (A.S). Allah replaced Hazrat Ismail (A.S) with a ram, rewarding Hazrat Ibrahim (A.S) for his unwavering faith. His life exemplifies devotion, trust, and sacrifice in the way of Allah, and he is considered a patriarch in Islam, Christianity, and Judaism.");
        prophetStories.put("Hazrat Musa (A.S)", "Hazrat Musa (A.S), also known as Moses, was chosen by Allah to guide the Children of Israel out of oppression in Egypt. Born during the reign of Pharaoh, who ordered the killing of male infants, Hazrat Musa (A.S) was miraculously saved and raised in Pharaoh’s palace. Later, Allah called him to prophethood at Mount Sinai and gave him miracles, including his staff that turned into a serpent and the ability to part the Red Sea. He was tasked with confronting Pharaoh and leading his people to freedom.\nHazrat Musa (A.S) faced great challenges, including the stubbornness of Pharaoh and the ungratefulness of his people. Despite this, he remained steadfast in his mission and upheld Allah’s commands. He also received the Torah, a divine scripture, as guidance for his people. His story is a testament to Allah’s help for the oppressed and the power of unwavering belief.");
        prophetStories.put("Hazrat Isa (A.S)", "Hazrat Isa (A.S), known as Jesus in Christianity, was a prophet born miraculously to Hazrat Maryam (A.S) without a father. Allah gifted him with extraordinary miracles, such as healing the sick, giving sight to the blind, and even bringing the dead to life by Allah’s will. Hazrat Isa (A.S) preached the message of monotheism and called people to worship Allah alone. He faced opposition from many who conspired against him and tried to harm him.\nAllah raised Hazrat Isa (A.S) to the heavens, saving him from the plots of his enemies. Muslims believe he was not crucified but will return before the Day of Judgment to defeat the false messiah (Dajjal) and establish justice. His story highlights the mercy of Allah, the importance of faith, and the miraculous nature of divine intervention.");
        prophetStories.put("Hazrat Muhammad (SAW)", "Hazrat Muhammad (S.A.W) is the final prophet and the Seal of the Prophets. He was born in Makkah in the noble Quraish tribe and was known as Al-Amin (the Trustworthy) even before receiving prophethood. At the age of 40, he received the first revelation from Allah through Angel Jibreel (Gabriel) in the Cave of Hira. His mission was to guide humanity to worship Allah, live righteously, and establish justice. He faced immense opposition, persecution, and hardships but remained steadfast.\nThe Prophet (S.A.W) established the Muslim community in Madinah and laid the foundations for Islamic teachings, which are preserved in the Quran and Sunnah. His life is a perfect example of mercy, patience, generosity, and leadership. Muslims around the world follow his teachings as a complete way of life. He is the most beloved and revered figure in Islam.");
        prophetStories.put("Hazrat Ismail (A.S)", "Hazrat Ismail (A.S) was the son of Hazrat Ibrahim (A.S) and Hazrat Hajrah (A.S). He is known for his obedience and unwavering submission to Allah’s commands. When Hazrat Ibrahim (A.S) received the divine order to sacrifice him, Hazrat Ismail (A.S) willingly agreed, demonstrating remarkable faith and trust in Allah. However, Allah replaced him with a ram at the last moment, making this event a symbol of sacrifice celebrated in Eid-ul-Adha.\nHazrat Ismail (A.S) is also associated with the construction of the Kaaba alongside his father. Together, they rebuilt the sacred house as a center of worship for Allah. Hazrat Ismail (A.S) lived among the people of Makkah, teaching them the ways of monotheism. His story emphasizes the importance of faith, submission, and dedication to Allah.");
        prophetStories.put("Hazrat Yusuf (A.S)", "Hazrat Yusuf (A.S), renowned for his beauty and wisdom, was the son of Hazrat Yaqub (A.S). His life story, known as one of the most beautiful narratives in the Quran, is filled with trials and divine support. As a child, he was thrown into a well by his jealous brothers and later sold as a slave in Egypt. Despite the hardships, he remained steadfast in his faith and displayed exceptional patience.\nEventually, Hazrat Yusuf (A.S) rose to prominence in Egypt, becoming a trusted advisor to the king due to his ability to interpret dreams. He reunited with his family after many years, forgiving his brothers for their actions. His story teaches the values of patience, forgiveness, and trust in Allah’s plans, even in the face of adversity.");
        prophetStories.put("Hazrat Dawood (A.S)", "Hazrat Dawood (A.S), also known as David, was a prophet and king blessed with wisdom, courage, and a beautiful voice. He is known for defeating the mighty warrior Jalut (Goliath) with his faith and skill, which led to his rise as a leader among his people. Allah granted him the Zabur (Psalms), a divine scripture, and bestowed upon him the ability to understand and influence nature, such as softening iron and communicating with birds.\nAs a ruler, Hazrat Dawood (A.S) was just and fair, setting an example of strong leadership and piety. He spent his life in worship and gratitude to Allah, earning the title of a righteous servant. His story highlights the rewards of faith, humility, and devotion to Allah.");
        prophetStories.put("Hazrat Suleman (A.S)", "Hazrat Suleman (A.S), the son of Hazrat Dawood (A.S), was a prophet and king known for his unparalleled wisdom and authority. Allah blessed him with the ability to communicate with animals and control the jinn, giving him command over a vast and unique kingdom. Despite his immense power, Hazrat Suleman (A.S) remained a humble servant of Allah, always acknowledging that his blessings were a test from his Creator.\nOne of the most famous events of his life is the story of the Queen of Sheba, who embraced Islam after witnessing his wisdom and the miraculous signs of Allah. Hazrat Suleman (A.S) is remembered for his justice, humility, and dedication to spreading the message of monotheism.");
        prophetStories.put("Hazrat Yunus (A.S)", "Hazrat Yunus (A.S), also known as Jonah, was sent by Allah to guide the people of Nineveh. When his people refused to listen to his message, Hazrat Yunus (A.S) left in frustration without Allah’s permission. As a consequence, he was swallowed by a giant fish or whale, where he remained in the darkness, praying for forgiveness with the famous supplication: \"La ilaha illa anta subhanaka inni kuntu minaz-zalimeen\" (There is no deity except You; exalted are You. Indeed, I have been of the wrongdoers).\nAllah accepted his repentance and saved him, allowing him to return to his people, who eventually accepted his message. His story is a powerful reminder of Allah’s mercy, the importance of patience, and the need to trust Allah’s timing.");
        prophetStories.put("Hazrat Ayub (A.S)", "Hazrat Ayyub (A.S), known as Job, is a shining example of patience and gratitude. He was blessed with immense wealth, a large family, and good health, but Allah tested him by taking away all his blessings. Despite losing everything, including his health, Hazrat Ayyub (A.S) remained steadfast in his faith and continued to praise Allah without complaint.\nAfter years of hardship, Allah restored his blessings, rewarding him for his unwavering patience and trust in divine wisdom. The story of Hazrat Ayyub (A.S) teaches the virtues of patience, gratitude, and reliance on Allah during trials and tribulations.");
    }

    // Method to retrieve prophet story
    public String getStory(String prophetName) {
        return prophetStories.getOrDefault(prophetName, "Story not found. Please ensure the name is correct.");
    }

    // Main application logic
    public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Stories of Prophets Application");
        System.out.println("-------------------------------------------------");
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Get Prophet Story");
            System.out.println("2. List All Prophets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
                continue;
            }
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the name of the Prophet (e.g., Hazrat Adam (A.S)): ");
                    String prophetName = scanner.nextLine();
                    String story = getStory(prophetName);
                    System.out.println("\nStory of " + prophetName + ":");
                    System.out.println(story);
                }
                case 2 -> {
                    System.out.println("\nList of Prophets:");
                    for (String name : prophetStories.keySet()) {
                        System.out.println("- " + name);
                    }
                }
                case 3 -> {
                    System.out.println("Exiting the application. Thank you for using it!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("THIS PROPHETS IS CUURENTLY NOT IN OUR DATA, WE WILL EXPAND THIS APP IN FUTURE");
            }
        }
    }

    public static void main(String[] args) {
        storiesofprophets app = new storiesofprophets();
        app.startApplication();
    }
}
