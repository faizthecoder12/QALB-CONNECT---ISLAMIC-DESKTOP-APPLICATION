package qalbconnect_dsa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class qalbconnect_GUI extends JFrame {
    // Add authentication fields
    private String username;
    private String password;
    private JPanel authPanel;
    
    // Instance of feature classes
    private namesofAllah namesApp;
    private qaza_e_umri_calculator qazaApp;
    private storiesofprophets storiesApp;
    private tasbeehcounter tasbeehApp;
    private verse_by_mood verseApp;

    // Main panel components
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private static final Color BACKGROUND_COLOR = Color.decode("#bfdecc");
    private static final Color TEXT_COLOR = Color.decode("#0a1d15");
    private static final Color BUTTON_COLOR = Color.decode("#bfdecc");
    private static final Color BUTTON_TEXT_COLOR = Color.decode("#0a1d15");

    public qalbconnect_GUI() {
        // Initialize feature classes
        namesApp = new namesofAllah();
        qazaApp = new qaza_e_umri_calculator();
        storiesApp = new storiesofprophets();
        tasbeehApp = new tasbeehcounter();
        verseApp = new verse_by_mood();

        // Setup main frame
        setTitle("QalbConnect - Islamic Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(BACKGROUND_COLOR);
        
        // Create authentication panel first
        createAuthPanel();

        // Create and add feature panels
        createHomePanel();
        createNamesPanel();
        createQazaPanel();
        createStoriesPanel();
        createTasbeehPanel();
        createVersePanel();

        // Add main panel to frame
        add(mainPanel);
        
        // Show auth panel first
        cardLayout.show(mainPanel, "Auth");

        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    private void createAuthPanel() {
        authPanel = new JPanel();
        authPanel.setLayout(new BoxLayout(authPanel, BoxLayout.Y_AXIS));
        authPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        authPanel.setBackground(BACKGROUND_COLOR);
    // Add Logo
        ImageIcon logoIcon = new ImageIcon("src/qalbconnectlogo.png");
        Image image = logoIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(scaledImage);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Welcome to QalbConnect");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 40));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBackground(BACKGROUND_COLOR);
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
 
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        
        styleComponent(usernameField);
        usernameField.setMaximumSize(new Dimension(300, 40));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        styleComponent(passwordField);
        passwordField.setMaximumSize(new Dimension(300, 40));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton signupButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Login");
  
        styleComponent(signupButton);
        signupButton.setMaximumSize(new Dimension(300, 50));
        signupButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        signupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        styleComponent(loginButton);
        loginButton.setMaximumSize(new Dimension(300, 50));
        loginButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        

        // Add components to login panel
        JLabel usernameLabel = new JLabel("Username:"); 
usernameLabel.setFont(new Font("Montserrat", Font.BOLD, 16));
usernameLabel.setForeground(TEXT_COLOR);
usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

JLabel passwordLabel = new JLabel("Password:");
passwordLabel.setFont(new Font("Montserrat", Font.BOLD, 16)); 
passwordLabel.setForeground(TEXT_COLOR);
passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

loginPanel.add(usernameLabel);
    loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    loginPanel.add(usernameField);
    loginPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    loginPanel.add(passwordLabel);
    loginPanel.add(Box.createRigidArea(new Dimension(0, 5)));
    loginPanel.add(passwordField);
    loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
    loginPanel.add(loginButton);
    loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    loginPanel.add(signupButton);

        // Add components to auth panel
        authPanel.add(logoLabel);
        authPanel.add(titleLabel);
        authPanel.add(loginPanel);

        // Add event listeners
        // Update login button listener
        loginButton.addActionListener(e -> {
        String inputUsername = usernameField.getText();
        String inputPassword = new String(passwordField.getPassword());
        
        Authentication auth = new Authentication();
        if (auth.logIn(inputUsername, inputPassword)) {
            cardLayout.show(mainPanel, "Home");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
        });

        signupButton.addActionListener(e -> {
        String newUsername = usernameField.getText();
        String newPassword = new String(passwordField.getPassword());
        
        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password!");
            return;
        }
        
        Authentication auth = new Authentication();
        if (auth.signUp(newUsername, newPassword)) {
            JOptionPane.showMessageDialog(this, "Sign up successful! You can now login.");
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists or error occurred!");
        }
        });

        mainPanel.add(authPanel, "Auth");
    }
    
    private void styleComponent(JComponent component) {
        component.setBackground(BACKGROUND_COLOR);
        component.setForeground(TEXT_COLOR);
        if (component instanceof JButton) {
            component.setBorder(BorderFactory.createLineBorder(TEXT_COLOR));
        }
    }
    
    private void styleTextComponent(JTextArea textArea) {
    textArea.setFont(new Font("Montserrat", Font.PLAIN, 18));
    textArea.setBackground(BACKGROUND_COLOR);
    textArea.setForeground(TEXT_COLOR);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
}
   
    private void createHomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        homePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        homePanel.setBackground(BACKGROUND_COLOR);
        
        // Add Logo
    ImageIcon logoIcon = new ImageIcon("src/qalbconnectlogo.png"); // Path to your logo 
    // Resize the image
    Image image = logoIcon.getImage(); // Get the image from the icon
    Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Width: 200, Height: 100
    logoIcon = new ImageIcon(scaledImage); // Create a new ImageIcon with scaled image

    JLabel logoLabel = new JLabel(logoIcon);
    logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("Qalb Connect - Islamic App");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 40));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        

        // Create buttons for each feature
        String[] features = {
            "99 Names of Allah",
            "Qaza Calculator",
            "Stories of Prophets",
            "Tasbeeh Counter",
            "Verses by Mood"
        };
        
        homePanel.add(logoLabel); // Add logo to the panel
        homePanel.add(titleLabel);
        homePanel.add(Box.createRigidArea(new Dimension(0, 20)));

        for (String feature : features) {
            JButton button = new JButton(feature);
            styleComponent(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(300, 50));
            button.setFont(new Font("Montserrat", Font.BOLD, 14));
            button.addActionListener(e -> cardLayout.show(mainPanel, feature));
            homePanel.add(button);
            homePanel.add(Box.createRigidArea(new Dimension(0, 15)));
        }

        mainPanel.add(homePanel, "Home");
    }

    private void createNamesPanel() {
        JPanel namesPanel = new JPanel(new BorderLayout(10, 10));
        namesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        namesPanel.setBackground(BACKGROUND_COLOR);

        // Create components
        JTextArea namesDisplay = new JTextArea();
        namesDisplay.setEditable(false);
        namesDisplay.setBackground(BACKGROUND_COLOR);
        namesDisplay.setForeground(TEXT_COLOR);
        JScrollPane scrollPane = new JScrollPane(namesDisplay);
        styleComponent(scrollPane);

        JButton displayAllButton = new JButton("Display All Names");
        JButton searchButton = new JButton("Search by Index");
        JButton backButton = new JButton("Back to Home");
        
        styleTextComponent(namesDisplay);
        
        styleComponent(displayAllButton);
        displayAllButton.setMaximumSize(new Dimension(300, 50));
        displayAllButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        displayAllButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        displayAllButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        styleComponent(searchButton);
        searchButton.setMaximumSize(new Dimension(300, 50));
        searchButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        styleComponent(backButton);
        backButton.setMaximumSize(new Dimension(300, 50));
        backButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Layout components
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        namesPanel.add(scrollPane, BorderLayout.CENTER);
        namesPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add event listeners
        displayAllButton.addActionListener(e -> {
            namesDisplay.setText("");
            for (int i = 0; i < namesofAllah.namesOfAllah.size(); i++) {
                namesDisplay.append((i + 1) + ". " + namesofAllah.namesOfAllah.get(i) + "\n");
            }
        });

        searchButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter index (1-99):");
            try {
                int index = Integer.parseInt(input);
                if (index >= 1 && index <= namesofAllah.namesOfAllah.size()) {
                    namesDisplay.setText(index + ". " + namesofAllah.namesOfAllah.get(index - 1));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid index!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        mainPanel.add(namesPanel, "99 Names of Allah");
    }

    private void createQazaPanel() {
    JPanel qazaPanel = new JPanel(new BorderLayout(10, 10));
    qazaPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    qazaPanel.setBackground(BACKGROUND_COLOR);

    // Create components for gender and period
    JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
    inputPanel.setBackground(BACKGROUND_COLOR);

    // Gender selection
    JLabel genderLabel = new JLabel("Gender:");
    genderLabel.setForeground(TEXT_COLOR);
    JComboBox<String> genderCombo = new JComboBox<>(new String[]{"Male", "Female"});
    styleComponent(genderCombo);

    // Period days input
    JLabel periodLabel = new JLabel("Period Days (3-10):");
    periodLabel.setForeground(TEXT_COLOR);
    JTextField periodField = new JTextField();
    styleComponent(periodField);
    periodLabel.setVisible(false);
    periodField.setVisible(false);

    // Date inputs
    JTextField startDateField = new JTextField();
    JTextField endDateField = new JTextField();
    
    styleComponent(startDateField);
    styleComponent(endDateField);

    JLabel startLabel = new JLabel("Baligh Date (dd-MM-yyyy):");
    JLabel endLabel = new JLabel("End Date (dd-MM-yyyy):");
    startLabel.setForeground(TEXT_COLOR);
    endLabel.setForeground(TEXT_COLOR);

    inputPanel.add(genderLabel);
    inputPanel.add(genderCombo);
    inputPanel.add(periodLabel);
    inputPanel.add(periodField);
    inputPanel.add(startLabel);
    inputPanel.add(startDateField);
    inputPanel.add(endLabel);
    inputPanel.add(endDateField);

    // Create result display
    JTextArea resultDisplay = new JTextArea();
    resultDisplay.setEditable(false);
    resultDisplay.setBackground(BACKGROUND_COLOR);
    resultDisplay.setForeground(TEXT_COLOR);
    styleTextComponent(resultDisplay);
    JScrollPane scrollPane = new JScrollPane(resultDisplay);
    styleComponent(scrollPane);

    // Create buttons
    JButton calculateButton = new JButton("Calculate");
    JButton adjustButton = new JButton("Adjust Prayer Counts");
    JButton backButton = new JButton("Back to Home");

    styleComponent(calculateButton);
    styleComponent(adjustButton);
    styleComponent(backButton);

    calculateButton.setMaximumSize(new Dimension(300, 50));
    adjustButton.setMaximumSize(new Dimension(300, 50));
    backButton.setMaximumSize(new Dimension(300, 50));

    calculateButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
    adjustButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
    backButton.setFont(new Font("Montserrat", Font.PLAIN, 16));

    JPanel buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.setBackground(BACKGROUND_COLOR);
    buttonPanel.add(calculateButton);
    buttonPanel.add(adjustButton);
    buttonPanel.add(backButton);

    qazaPanel.add(inputPanel, BorderLayout.NORTH);
    qazaPanel.add(scrollPane, BorderLayout.CENTER);
    qazaPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Gender selection listener
    genderCombo.addActionListener(e -> {
        boolean isFemale = genderCombo.getSelectedItem().equals("Female");
        periodLabel.setVisible(isFemale);
        periodField.setVisible(isFemale);
        qazaPanel.revalidate();
        periodField.setText("");  // Clear the field when hidden
    });

    // Store prayer counts
    final long[] prayerCounts = new long[6]; // [fajr, zuhr, asr, maghrib, isha, witr]

    // Calculate button listener
    calculateButton.addActionListener(e -> {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate startDate = LocalDate.parse(startDateField.getText().trim(), formatter);
            LocalDate endDate = LocalDate.parse(endDateField.getText().trim(), formatter);

            if (endDate.isBefore(startDate)) {
                JOptionPane.showMessageDialog(this, "End date cannot be before start date!");
                return;
            }

            String gender = genderCombo.getSelectedItem().toString().toLowerCase();
            int periodDays = 0;
            if (gender.equals("female")) {
                try {
                    periodDays = Integer.parseInt(periodField.getText().trim());
                    if (periodDays < 3 || periodDays > 10) {
                        JOptionPane.showMessageDialog(this, "Period days must be between 3 and 10!");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid number for period days!");
                    return;
                }
            }

            long totalDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;
            long missedDays = totalDays;

            if (gender.equals("female")) {
                long monthsBetween = ChronoUnit.MONTHS.between(startDate.withDayOfMonth(1), 
                                                             endDate.withDayOfMonth(1));
                missedDays -= monthsBetween * periodDays;
                if (missedDays < 0) missedDays = 0;
            }

            // Update prayer counts
            for (int i = 0; i < prayerCounts.length; i++) {
                prayerCounts[i] = missedDays;
            }

            // Update display
            resultDisplay.setText(String.format("""
                Calculation Results:
                
                Date Range: %s to %s
                Total Days: %d
                Missed Days (excluding periods): %d
                
                Prayer Counts:
                Fajr: %d
                Zuhr: %d
                Asr: %d
                Maghrib: %d
                Isha: %d
                Witr: %d
                """, 
                startDate.format(formatter),
                endDate.format(formatter),
                totalDays,
                missedDays,
                prayerCounts[0],
                prayerCounts[1],
                prayerCounts[2],
                prayerCounts[3],
                prayerCounts[4],
                prayerCounts[5]
            ));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter valid dates in the format dd-MM-yyyy",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    });

    adjustButton.addActionListener(e -> {
        if (resultDisplay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please calculate prayer counts first!",
                "No Data",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        showAdjustmentDialog(prayerCounts, resultDisplay);
    });

    backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

    mainPanel.add(qazaPanel, "Qaza Calculator");
}

private void showAdjustmentDialog(long[] counts, JTextArea resultDisplay) {
    JDialog dialog = new JDialog(this, "Adjust Prayer Counts", true);
    dialog.setLayout(new BorderLayout());
    dialog.getContentPane().setBackground(BACKGROUND_COLOR);

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    mainPanel.setBackground(BACKGROUND_COLOR);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    // Add help text
    JLabel helpLabel = new JLabel("<html>Enter positive or negative numbers to adjust counts.<br>" +
                                 "Example: '+5' to add or '-3' to subtract</html>");
    helpLabel.setForeground(TEXT_COLOR);
    helpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    mainPanel.add(helpLabel);
    mainPanel.add(Box.createVerticalStrut(10));

    String[] prayerNames = {"Fajr", "Zuhr", "Asr", "Maghrib", "Isha", "Witr"};
    JTextField[] adjustmentFields = new JTextField[6];

    for (int i = 0; i < prayerNames.length; i++) {
        JPanel prayerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        prayerPanel.setBackground(BACKGROUND_COLOR);
        
        JLabel nameLabel = new JLabel(prayerNames[i] + " (Current: " + counts[i] + "):");
        nameLabel.setForeground(TEXT_COLOR);
        nameLabel.setPreferredSize(new Dimension(200, 25));
        
        adjustmentFields[i] = new JTextField(10);
        adjustmentFields[i].setText("0");
        styleComponent(adjustmentFields[i]);
        
        prayerPanel.add(nameLabel);
        prayerPanel.add(adjustmentFields[i]);
        mainPanel.add(prayerPanel);
    }

    JButton applyButton = new JButton("Apply Adjustments");
    styleComponent(applyButton);
    applyButton.setFont(new Font("Montserrat", Font.PLAIN, 14));
    applyButton.setMaximumSize(new Dimension(200, 40));
    applyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setBackground(BACKGROUND_COLOR);
    buttonPanel.add(applyButton);

    applyButton.addActionListener(e -> {
        try {
            for (int i = 0; i < counts.length; i++) {
                String text = adjustmentFields[i].getText().trim();
                if (!text.isEmpty() && !text.equals("0")) {
                    long adjustment;
                    if (text.startsWith("+")) {
                        adjustment = Long.parseLong(text.substring(1));
                    } else {
                        adjustment = Long.parseLong(text);
                    }
                    counts[i] = Math.max(0, counts[i] + adjustment);
                }
            }

            // Update the result display with new counts
            resultDisplay.setText(String.format("""
                Updated Prayer Counts:
                
                Fajr: %d
                Zuhr: %d
                Asr: %d
                Maghrib: %d
                Isha: %d
                Witr: %d
                """,
                counts[0], counts[1], counts[2],
                counts[3], counts[4], counts[5]
            ));

            dialog.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog,
                "Please enter valid numbers for adjustments",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    });

    mainPanel.add(Box.createVerticalStrut(10));
    mainPanel.add(buttonPanel);

    JScrollPane scrollPane = new JScrollPane(mainPanel);
    scrollPane.setBackground(BACKGROUND_COLOR);
    dialog.add(scrollPane);

    dialog.setSize(400, 450);
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
}

    private void createStoriesPanel() {
        JPanel storiesPanel = new JPanel(new BorderLayout(10, 10));
        storiesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        storiesPanel.setBackground(BACKGROUND_COLOR);

        // Create components
        JTextArea storyDisplay = new JTextArea();
        storyDisplay.setEditable(false);
        storyDisplay.setWrapStyleWord(true);
        storyDisplay.setLineWrap(true);
        storyDisplay.setBackground(BACKGROUND_COLOR);
        storyDisplay.setForeground(TEXT_COLOR);
        JScrollPane scrollPane = new JScrollPane(storyDisplay);
        styleComponent(scrollPane);

        JComboBox<String> prophetSelect = new JComboBox<>(storiesofprophets.prophetStories.keySet().toArray(new String[0]));
        styleComponent(prophetSelect);

        JButton showStoryButton = new JButton("Show Story");
        JButton backButton = new JButton("Back to Home");
        
        styleTextComponent(storyDisplay);
        
        styleComponent(showStoryButton);
        showStoryButton.setMaximumSize(new Dimension(300, 50));
        showStoryButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        showStoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showStoryButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
        styleComponent(backButton);
        backButton.setMaximumSize(new Dimension(300, 50));
        backButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.add(prophetSelect);
        controlPanel.add(showStoryButton);
        controlPanel.add(backButton);

        storiesPanel.add(scrollPane, BorderLayout.CENTER);
        storiesPanel.add(controlPanel, BorderLayout.SOUTH);

        // Add event listeners
        showStoryButton.addActionListener(e -> {
            String selectedProphet = (String) prophetSelect.getSelectedItem();
            String story = storiesofprophets.prophetStories.get(selectedProphet);
            storyDisplay.setText(selectedProphet + "\n\n" + story);
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        mainPanel.add(storiesPanel, "Stories of Prophets");
    }

    private void createTasbeehPanel() {
        JPanel tasbeehPanel = new JPanel(new BorderLayout(10, 10));
        tasbeehPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tasbeehPanel.setBackground(BACKGROUND_COLOR);

        // Create components
        JLabel countLabel = new JLabel("0", SwingConstants.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 54));
        countLabel.setForeground(TEXT_COLOR);

        JButton incrementButton = new JButton("Count (+1)");
        JButton resetButton = new JButton("Reset");
        JButton undoButton = new JButton("Undo");
        JButton backButton = new JButton("Back to Home");
       
        
        styleComponent(incrementButton);
        incrementButton.setMaximumSize(new Dimension(300, 50));
        incrementButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        incrementButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        incrementButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        styleComponent(resetButton);
        resetButton.setMaximumSize(new Dimension(300, 50));
        resetButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        styleComponent(undoButton);
        undoButton.setMaximumSize(new Dimension(300, 50));
        undoButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        undoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        undoButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        styleComponent(backButton);
        backButton.setMaximumSize(new Dimension(300, 50));
        backButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(incrementButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(backButton);

        tasbeehPanel.add(countLabel, BorderLayout.CENTER);
        tasbeehPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add event listeners
        tasbeehcounter counter = new tasbeehcounter();

        incrementButton.addActionListener(e -> {
            counter.increment();
            countLabel.setText(String.valueOf(counter.getCurrentCount()));
        });

        resetButton.addActionListener(e -> {
            counter.reset();
            countLabel.setText(String.valueOf(counter.getCurrentCount()));
        });

        undoButton.addActionListener(e -> {
            counter.undo();
            countLabel.setText(String.valueOf(counter.getCurrentCount()));
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        mainPanel.add(tasbeehPanel, "Tasbeeh Counter");
    }

    private void createVersePanel() {
        JPanel versePanel = new JPanel(new BorderLayout(10, 10));
        versePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        versePanel.setBackground(BACKGROUND_COLOR);

        // Create components
        JTextArea verseDisplay = new JTextArea();
        verseDisplay.setEditable(false);
        verseDisplay.setWrapStyleWord(true);
        verseDisplay.setLineWrap(true);
        verseDisplay.setBackground(BACKGROUND_COLOR);
        verseDisplay.setForeground(TEXT_COLOR);
        JScrollPane scrollPane = new JScrollPane(verseDisplay);
        styleComponent(scrollPane);

        JComboBox<String> moodSelect = new JComboBox<>(verse_by_mood.moodVerses.keySet().toArray(new String[0]));
        styleComponent(moodSelect);

        JButton getVerseButton = new JButton("Get Verse");
        JButton backButton = new JButton("Back to Home");
        
        styleTextComponent(verseDisplay);

        styleComponent(getVerseButton);
        getVerseButton.setMaximumSize(new Dimension(300, 50));
        getVerseButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        getVerseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        getVerseButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
        styleComponent(backButton);
        backButton.setMaximumSize(new Dimension(300, 50));
        backButton.setFont(new Font("Montserrat", Font.PLAIN, 16));
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.add(new JLabel("Select Mood:") {{ setForeground(TEXT_COLOR); }});
        controlPanel.add(moodSelect);
        controlPanel.add(getVerseButton);
        controlPanel.add(backButton);

        versePanel.add(scrollPane, BorderLayout.CENTER);
        versePanel.add(controlPanel, BorderLayout.SOUTH);

        // Add event listeners
        getVerseButton.addActionListener(e -> {
            String selectedMood = (String) moodSelect.getSelectedItem();
            verse_by_mood.MoodVerse verse = verseApp.getRandomVerseForMood(selectedMood);
            if (verse != null) {
                verseDisplay.setText(String.format("""
                    Mood: %s

                    Verse:
                    %s

                    Reference:
                    %s
                    """, selectedMood, verse.verse, verse.reference));
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        mainPanel.add(versePanel, "Verses by Mood");
    }

    public static void main(String[] args) {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Launch application
        SwingUtilities.invokeLater(() -> {
            qalbconnect_GUI app = new qalbconnect_GUI();
            app.setVisible(true);
        });
    }
}