import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class Display {
	// file name[0], player name[1], gender[2], progress[3], long comp[4], yes
	// comp[5], carl comp[6], m&v comp[7]
	static String[] data = { "fileName", "player name", "gender", "0", "0", "0", "0", "0" };
	static boolean cont = false;

	// title font
	static Font h1 = new Font("courier", Font.PLAIN, 100);
	// heading font
	static Font h2 = new Font("courier", Font.PLAIN, 40);
	// button font
	static Font h3 = new Font("courier", Font.PLAIN, 17);
	// character name font
	static Font h4 = new Font("courier", Font.PLAIN, 25);
	// char dialogue font
	static Font dia = new Font("courier", Font.PLAIN, 20);

	static JFrame jfrm = new JFrame("LuvMi");
	static ImageIcon icon = new ImageIcon("C:\\Simulator\\icon.png");

	static AudioPlayer MGP = AudioPlayer.player;
	static AudioStream BGM;
	AudioData MD;

	public static void def() {
		jfrm.setIconImage(icon.getImage());
		jfrm.setLayout(new BorderLayout());
		jfrm.setSize(1400, 900);
		jfrm.setResizable(false);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@SuppressWarnings("restriction")
	public static void musicStart(String file) { // Plays the background music
		ContinuousAudioDataStream loop = null;

		try {
			InputStream test = new FileInputStream(file);
			BGM = new AudioStream(test);
			AudioPlayer.player.start(BGM);
			// MD = BGM.getData();
			// loop = new ContinuousAudioDataStream(MD);

		} catch (FileNotFoundException e) {
			System.out.print(e.toString());
		} catch (IOException error) {
			System.out.print(error.toString());
		}
		MGP.start(loop);
	}

	public static void musicStop() {
		// don't try and do things with a null object!
		if (BGM != null) {
			AudioPlayer.player.stop(BGM);
		}
		System.out.println("music stopped");
	}

	public static void title() throws IOException, InterruptedException {
		ImageIcon title = new ImageIcon("C:\\Simulator\\titlegif.gif");

		musicStart("C:\\Simulator\\theme.wav");

		JLayeredPane panel = new JLayeredPane();
		ImageIcon bg = new ImageIcon("c:\\Simulator\\bg.jpg");
		JLabel back = new JLabel(bg);
		back.setSize(1400, 900);

		panel.setLayout(null);
		panel.setSize(1400, 900);

		JLabel name = new JLabel(title);
		name.setBounds(800, 25, 588, 495);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(name);
		panel.add(back);
		panel.moveToBack(back);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);

	}

	public static void titleCorrupt() throws IOException, InterruptedException {
		ImageIcon title = new ImageIcon("C:\\Simulator\\titlegif.gif");

		musicStart("C:\\Simulator\\themecorrupt.wav");

		ImageIcon bg = new ImageIcon("C:\\Simulator\\bgcorrupt.gif");
		JLabel lab = new JLabel(bg);
		lab.setSize(1400, 900);

		JLayeredPane panel = new JLayeredPane();
		panel.setLayout(null);
		panel.setSize(1400, 900);

		JLabel name = new JLabel(title);
		name.setBounds(800, 25, 588, 495);

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW GAME");
		newGame.setBounds(70, 600, 250, 40);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD GAME");
		loadGame.setBounds(70, 660, 250, 40);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("QUIT GAME");
		quit.setBounds(70, 720, 250, 40);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		panel.add(lab);
		panel.add(newGame);
		panel.add(loadGame);
		panel.add(quit);
		panel.add(name);

		panel.moveToBack(lab);

		jfrm.getContentPane().add(panel);

		def();

		jfrm.setVisible(true);

	}

	public static void dayTransition(int day) {
		def();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());

		JLabel text = new JLabel("Day " + day);
		text.setFont(h2);
		text.setForeground(Color.WHITE);
		text.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(text);

		jfrm.add(panel);

		jfrm.setVisible(true);
	}

	public static void blackScreen(String line1, String line2, String line3) {

		def();

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());

		JLabel text = new JLabel("<html>" + line1 + "<br>" + line2 + "<br>" + line3 + "</html>");
		text.setFont(h3);
		text.setForeground(Color.white);
		text.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(text);

		jfrm.getContentPane().add(panel);
		jfrm.getContentPane().setBackground(Color.BLACK);
		jfrm.setVisible(true);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (data[3]) {
				case "0":
					try {
						data[3] = "1";
						inGame("schoolclassroom.jpg", "", "3:01PM",
								"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
								"not looking forward to going home. The weatherman didn’t say anything about it",
								"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					break;
				}
			}
		});

	}

	// display save game screen
	public static void saveScreen() {
		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("LUV MI");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// save game as label
		JLabel lbl = new JLabel("SAVE GAME AS");
		lbl.setFont(h2);
		lbl.setForeground(Color.WHITE);

		// save icon display
		Icon icon = new ImageIcon("C:\\Simulator\\saveicon.jpg");
		JLabel photo = new JLabel(icon);

		// text field for file name specification
		// CHANGE: display confirm dialog if filename already exits in folder
		JTextField fileName = new JTextField(30);
		fileName.setFont(h3);

		// save button
		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(h3);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFocusable(false);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(lbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(fileName, c);
		fileName.setPreferredSize(new Dimension(10, 30));
		c.gridx = 1;
		c.gridy = 3;
		pane.add(saveButton, c);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					data[0] = fileName.getText();
					FileHandler.save(fileName.getText(), data);
				} catch (IOException e1) {
					System.out.println("Save failed.");
				}
				clear();
				try {
					clear();
					title();
				} catch (IOException | InterruptedException e1) {
					System.out.println("Failed.");
				}
			}
		});

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

		jfrm.setVisible(true);
	}

	// display load game screen
	public static void loadScreen() {
		boolean loaded = false;

		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("LUV MI");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// load game label
		JLabel lbl = new JLabel("LOAD GAME FILE");
		lbl.setFont(h2);
		lbl.setForeground(Color.WHITE);

		// load icon display
		Icon icon = new ImageIcon("C:\\Simulator\\saveicon.jpg");
		JLabel photo = new JLabel(icon);

		// text field for file name specification
		// CHANGE: display error if file doesn't exist in folder
		JTextField fileName = new JTextField(30);
		fileName.setFont(h3);

		// load button
		JButton loadButton = new JButton("LOAD");
		loadButton.setFont(h3);
		loadButton.setBackground(Color.WHITE);
		loadButton.setFocusable(false);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(lbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(fileName, c);
		fileName.setPreferredSize(new Dimension(10, 30));
		c.gridx = 1;
		c.gridy = 3;
		pane.add(loadButton, c);
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					clear();
					data = FileHandler.load(fileName.getText());
					FileHandler.direct(data);
				} catch (IOException e1) {
					System.out.println("Load failed.");
				}
			}
		});

		jfrm.setLayout(new GridLayout(3, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(photo);
		jfrm.add(pane);

		jfrm.setVisible(true);
	}

	public static void newGame() {
		// make basic background and window
		def();
		jfrm.getContentPane().setBackground(Color.BLACK);

		// make pane to handle buttons, text field
		JPanel pane = new JPanel();
		pane.setBackground(Color.BLACK);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// label for game title
		JLabel empty = new JLabel("HELLO. WELCOME.");
		empty.setForeground(Color.WHITE);
		empty.setFont(h1);
		empty.setHorizontalAlignment(JLabel.CENTER);

		// name text field
		JTextField name = new JTextField(30);
		name.setFont(h3);

		// gender buttons
		JRadioButton male = new JRadioButton("MALE");
		male.setFont(h3);
		male.setOpaque(false);
		JRadioButton female = new JRadioButton("FEMALE");
		female.setFont(h3);
		female.setOpaque(false);
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);

		// start button
		JButton saveButton = new JButton("START");
		saveButton.setFont(h3);
		saveButton.setBackground(Color.WHITE);
		saveButton.setFocusable(false);

		JLabel nameLbl = new JLabel("ENTER NAME");
		nameLbl.setFont(h2);
		nameLbl.setForeground(Color.white);

		// positioning of field and button
		c.gridx = 1;
		c.gridy = 0;
		pane.add(nameLbl, c);
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(20, 0, 0, 0);
		pane.add(name, c);
		name.setPreferredSize(new Dimension(10, 30));

		JPanel button = new JPanel();
		button.setBackground(Color.black);
		button.setLayout(new FlowLayout());
		saveButton.setHorizontalAlignment(JButton.CENTER);
		button.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data[1] = name.getText();
				if (male.isSelected()) {
					data[2] = "male";
				} else if (female.isSelected()) {
					data[2] = "female";
				}
				clear();
				saveScreen();
			}
		});

		JPanel genders = new JPanel();
		genders.setBackground(Color.black);
		genders.setLayout(new FlowLayout());
		male.setHorizontalAlignment(JRadioButton.CENTER);
		male.setForeground(Color.white);
		female.setHorizontalAlignment(JRadioButton.CENTER);
		female.setForeground(Color.white);
		genders.add(male);
		genders.add(female);

		jfrm.setLayout(new GridLayout(4, 1, 0, 0));
		jfrm.add(empty);
		jfrm.add(pane);
		jfrm.add(genders);
		jfrm.add(button);

		jfrm.setVisible(true);
	}

	public static void inGame(String background, String charimg, String charname, String line1, String line2,
			String line3) throws IOException {

		JLayeredPane pane = new JLayeredPane();
		pane.setPreferredSize(new Dimension(1400, 900));

		JLabel textbg = new JLabel(new ImageIcon("C:\\Simulator\\textbg.png"));
		JLabel bg = new JLabel(new ImageIcon("C:\\Simulator\\" + background));
		JLabel chara = new JLabel(new ImageIcon("C:\\Simulator\\" + charimg));
		JLabel frame = new JLabel(new ImageIcon("C:\\Simulator\\gamebgt.png"));
		JLabel charaname = new JLabel(charname);
		charaname.setFont(h4);
		JLabel text1 = new JLabel(line1);
		text1.setFont(dia);
		JLabel text2 = new JLabel(line2);
		text2.setFont(dia);
		JLabel text3 = new JLabel(line3);
		text3.setFont(dia);

		pane.add(bg, 0);
		bg.setBounds(0, 0, 1394, 866);
		pane.add(chara, 1);
		chara.setBounds(100, 50, 500, 600);
		frame.setBounds(0, 0, 1394, 866);
		textbg.setBounds(15, 500, 1356, 295);
		pane.add(textbg, 2);
		pane.add(frame, 2);
		pane.add(charaname, 3);
		charaname.setBounds(100, 513, 200, 50);
		charaname.setForeground(Color.white);
		pane.add(text1, 3);
		text1.setBounds(70, 615, 1300, 30);
		text1.setForeground(Color.white);
		pane.add(text2, 3);
		text2.setBounds(70, 645, 1300, 30);
		text2.setForeground(Color.white);
		pane.add(text3, 3);
		text3.setBounds(70, 675, 1300, 30);
		text3.setForeground(Color.white);
		pane.setLayout(null);

		if (charimg.contains("yes")) {
            chara.setBounds(0, 0, 800, 1000);
        }
        if (charimg.contains("carl")) {
            chara.setBounds(100, 50, 878, 825);
        }
        if (charimg.contains("long")) {
            chara.setBounds(0, 0, 941, 1063);
        }
        if (charimg.contains("mandv")) {
            chara.setBounds(100, 50, 879, 1113);
        }

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 815, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("EXIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					FileHandler.save(data[0], data);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					title();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		textbg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 1:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("schoolclassroom.jpg", "", "3:01PM",
								"You sigh as you gather your stuff from your desk. The bell has just rung, but you’re",
								"not looking forward to going home. The weatherman didn’t say anything about it",
								"raining today, yet the sky looks dark and dreary. You don’t have your umbrella. ");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 2:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
								"Continue out of the classroom and find an umbrella somewhere else.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 4:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 2));
					try {
						response("schoolclassroom.jpg", "'Thank you!'", "'I'll make sure to return it tomorrow.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 5:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolclassroom.jpg", "Ask the quiet boy next to you if he has an umbrella.",
								"Continue out of the classroom and find an umbrella somewhere else.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 7:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("schoolcafeteria.jpg", "'I'm sorry, is this yours?'",
								"Shrug and leave to go home with the umbrella.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 9:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("townstreet.jpg", "", "3:10PM",
								"You begin your walk home, taking in the sights of the quiet town around you. Despite having",
								"lived here for only two months, it feels like home already and you smile to yourself.",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 10:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("townstreet.jpg", "carl_happy.png", "CARL",
								"Excuse me, but do you know the way to Miyazaki High School? I’m a transfer student from Kyoto",
								"and these mountain roads got me turned around.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 11:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("townstreet.jpg", "'Of course, go down this road and take a left after the bridge. It’s right there.'",
								"'Ask someone else, I'm in a rush.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 13:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "", "3:30PM",
								"Home… finally. You take a deep breath and smile at the sight of your house after a long day of",
								"school.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 14:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "VITA",
								"Is this where you live?",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 15:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "mandv_happy.png", "MORT",
								"We did not know you were our neighbor.",
								"", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 16:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'Yes, you two are in my history class, right?'",
								"'Do I know you?'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 18:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'I'll see you tomorrow then!'",
								"'Come over to study sometime. It was nice seeing you.'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 20:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						response("house.png", "'Sorry, I still don't remember...'",
								"'Oh, yes! I'll see you in class tomorrow!'");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 22:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("house.png", "", "3:44PM",
								"You wave goodbye to Mort and Vita and stretch your arms above your head, yawning. This",
								"town is certainly full of interesting people. You can't wait to see what tomorrow brings.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 23:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					dayTransition(1);
					break;
				}
			}
		});

		pane.add(newGame, 3);
		pane.add(loadGame, 3);
		pane.add(quit, 3);
		pane.moveToFront(newGame);
		pane.moveToFront(loadGame);
		pane.moveToFront(quit);
		pane.moveToBack(chara);
		pane.moveToBack(bg);

		def();

		jfrm.getContentPane().add(pane);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 900);
	}

	public static JButton responseButton(String text, int location) {
		JButton button = new JButton(text);
		switch (location) {
		case 1:
			button.setBounds(350, 270, 700, 35);
			break;
		case 2:
			button.setBounds(350, 370, 700, 35);
			break;
		case 3:
			button.setBounds(350, 470, 700, 35);
			break;
		}
		button.setBackground(Color.WHITE);
		button.setFocusable(false);
		button.setFont(h3);

		return button;
	}

	public static void response(String background, String res1, String res2) throws IOException {
		JLayeredPane pane = new JLayeredPane();
		pane.setPreferredSize(new Dimension(1400, 900));

		JLabel bg = new JLabel(new ImageIcon("C:\\Simulator\\" + background));
		JLabel frame = new JLabel(new ImageIcon("C:\\Simulator\\gamebgt.png"));
		JButton r1 = new JButton(res1);
		JButton r2 = new JButton(res2);

		pane.add(bg, 0);
		bg.setBounds(0, 0, 1394, 866);
		frame.setBounds(0, 0, 1394, 866);
		pane.add(frame, 1);
		pane.add(r1, 2);
		r1.setBounds(150, 350, 1080, 50);
		r1.setBackground(Color.black);
		r1.setForeground(Color.WHITE);
		r1.setFocusable(false);
		r1.setFont(h3);
		pane.add(r2, 2);
		r2.setBounds(150, 450, 1080, 50);
		r2.setBackground(Color.black);
		r2.setForeground(Color.WHITE);
		r2.setFocusable(false);
		r2.setFont(h3);
		pane.setLayout(null);

		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 3:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("schoolclassroom.jpg", "yes_happy.png", "3:02PM",
								"Wha… Oh! Yeah. Umbrella. Uh, give me a second. Er… uh… got it!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;

				case 6:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[4] = Integer.toString((Integer.parseInt(data[4]) + 1));
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You exit the building with a smile, holding the boy’s umbrella over your head.", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 8:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[5] = Integer.toString((Integer.parseInt(data[5]) + 1));
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"He shakes his head and exits the room. You smile to yourself and leave with the",
								"umbrella in hand, stepping out into the rain.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 12:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 1));
						inGame("townstreet.jpg", "carl_happy.png", "CARL", "Thank you so much!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 17:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "It is nice you remember.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 19:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "Yes. Tomorrow.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 21:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "Unfortunate...", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				switch (Integer.parseInt(data[3])) {
				case 3:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 4));
					try {
						inGame("schoolcafeteria.jpg", "long_normal.png", "3:03PM",
								"You see a disposable umbrella leaning against the wall and go to take it. Upon",
								"looking around, you notice someone watching you.", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 6:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You exit the building with a smile, holding the boy’s umbrella over your head.", "",
								"");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 8:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						inGame("schoolcourtyard.jpg", "", "3:04PM",
								"You take the umbrella in hand and step out into the rain, ready to go home.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 12:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[6] = Integer.toString((Integer.parseInt(data[6]) + 0));
						inGame("townstreet.jpg", "carl_angry.png", "CARL", "Whatever, I don't need your help!", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 17:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 0));
						inGame("house.png", "mandv_happy.png", "MORT", "History class.", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 19:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 3));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "It was nice seeing you as well. :)", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 21:
					data[3] = Integer.toString((Integer.parseInt(data[3]) + 1));
					try {
						data[7] = Integer.toString((Integer.parseInt(data[7]) + 1));
						inGame("house.png", "mandv_happy.png", "VITA", "Yes. Tomorrow. :)", "", "");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
			}
		});

		JButton newGame, loadGame, quit;
		newGame = new JButton("NEW");
		newGame.setBounds(9, 815, 140, 35);
		newGame.setBackground(Color.WHITE);
		newGame.setFocusable(false);
		newGame.setFont(h3);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				newGame();
			}
		});
		loadGame = new JButton("LOAD");
		loadGame.setBounds(169, 815, 140, 35);
		loadGame.setBackground(Color.WHITE);
		loadGame.setFocusable(false);
		loadGame.setFont(h3);
		loadGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				loadScreen();
			}
		});
		quit = new JButton("EXIT");
		quit.setBounds(329, 815, 140, 35);
		quit.setBackground(Color.WHITE);
		quit.setFocusable(false);
		quit.setFont(h3);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				try {
					FileHandler.save(data[0], data);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					title();
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		pane.add(newGame, 3);
		pane.add(loadGame, 3);
		pane.add(quit, 3);
		pane.moveToFront(newGame);
		pane.moveToFront(loadGame);
		pane.moveToFront(quit);
		pane.moveToBack(bg);

		def();

		jfrm.getContentPane().add(pane);

		jfrm.setVisible(true);
		jfrm.setSize(1400, 900);
	}

	// clear frame contents
	public static void clear() {
		musicStop();
		System.out.println("cleared");
		jfrm.getContentPane().revalidate();
		jfrm.getContentPane().removeAll();
		jfrm.getContentPane().repaint();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		title();
		//		blackScreen("Welcome to Urashina, a place full of unique opportunities and characters eager to meet you. ",
//				"As a new student at Miyazaki High School, you should take your time to explore this unusual",
//				"town and all that it has to offer. Good luck, and have fun!");
	}
}
