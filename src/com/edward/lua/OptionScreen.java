package com.edward.lua;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import com.edward.bootstrap.MainFrame.MainGIFScreen;
import com.edward.utils.DownloadDialog;
import com.edward.utils.EyeThrowableDealer;
import com.edward.utils.Utils;

import org.apache.commons.io.FileUtils;

public class OptionScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton back = null;

	private JButton downloadFont() {
		back = new JButton("Download Minecraftia font") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(250, 50));
		back.setLocation(80, 30);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 13));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DownloadDialog
							.download(
									new JFrame(),
									new URL(
											"https://github.com/eyeballcode/CC-Lua-Editor/raw/master/src/com/edward/lua/Minecraftia.ttf"),
									new FileOutputStream(Utils.workingDir
											+ "Minecraftia.ttf"));
				} catch (Exception e1) {
					EyeThrowableDealer etd = new EyeThrowableDealer();
					etd.load(e1);
					etd.print();
				}
				JOptionPane.showMessageDialog(new JFrame(), "Done!");
			}

		});
		return back;

	}

	private JButton installFont() {
		back = new JButton("Install Minecraftia font") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(200, 50));
		back.setLocation(370, 30);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 13));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().open(
							new File(Utils.workingDir + "Minecraftia.ttf"));
					JOptionPane.showMessageDialog(new JFrame(),
							"Please Restart after installing font!");
				} catch (Exception e1) {
					EyeThrowableDealer etd = new EyeThrowableDealer();
					etd.load(e1);
					etd.print();
					JOptionPane
							.showMessageDialog(
									new JFrame(),
									"Could not find Minecraftia.ttf in your directory!",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		return back;

	}

	private JButton done() {
		back = new JButton("Done!") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(100, 50));
		back.setLocation(108, 300);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				dispose();
				new MainGIFScreen(false);
			}

		});
		return back;

	}

	private JButton resetWD() {
		back = new JButton("Reset Working Directory") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(490, 50));
		back.setLocation(80, 100);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int ans = JOptionPane.showConfirmDialog(new JFrame(),
							"Are you sure you want to reset?");
					if (ans == 0) {
						Object[] options = { "Delete Now", "Later",
								"Forget it!" };
						int ans2 = JOptionPane.showOptionDialog(new JFrame(),
								"When would you like to reset?", "Question",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[2]);
						System.out.println(ans2);
						if (ans2 == 0) {
							System.out.println("Too late to turn back...");
							JOptionPane.showMessageDialog(new JFrame(),
									"You know you have to quit right?");
							FileUtils
									.deleteDirectory(new File(Utils.workingDir));
							System.exit(0);
						} else if (ans2 == 1) {
							System.out.println("Later then!");
							File[] files = new File(Utils.workingDir)
									.listFiles();
							for (int i = 0; i < files.length; i++) {
								if (!files[i].isDirectory()) {
									new File(
											Utils.workingDir
													+ files[i].getName()).deleteOnExit();
									System.out.println("[INFO] " + new Date()
											+ ": File " + files[i].getName()
											+ " going to be deleted!");
								}
							}

							Runtime.getRuntime().addShutdownHook(new Thread() {

							      @Override
							      public void run() {
										try {
											FileUtils.deleteDirectory(new File(Utils.workingDir + "Workspace"));
											System.out.println("[INFO] " + new Date()
											+ ": Deleted Workspace directory!");
										} catch (IOException e) {
											System.out.println("[ERROR] " + new Date()
											+ ": Could not delete your workspace directory! It will remain there!");
											EyeThrowableDealer etd = new EyeThrowableDealer();
											etd.load(e);
											etd.print();
							      }
											try {
												FileUtils.deleteDirectory(new File(Utils.workingDir));
											System.out.println("[INFO] " + new Date()
											+ ": Deleted luaprojects/ directory!");
											
											} catch (IOException e) {
												System.out.println("[ERROR] " + new Date()
												+ ": Could not delete your luaprojects/ directory! It will remain there!");
												EyeThrowableDealer etd = new EyeThrowableDealer();
												etd.load(e);
												etd.print();
											}
							 }});
						} else {
							System.out.println("Forget it");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		return back;

	}

	private JButton back() {
		back = new JButton("Bring me back") {
			private static final long serialVersionUID = -3089163832904127158L;

			@Override
			public void setBorder(Border b) {
			}
		};
		back.setBackground(new Color(204, 76, 76));
		back.setOpaque(true);
		back.setForeground(Color.WHITE);
		back.setSize(new Dimension(300, 50));
		back.setLocation(280, 300);
		back.setFont(new Font("Minecraftia", Font.PLAIN, 17));
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				dispose();
				new MainGIFScreen(false);
			}

		});
		return back;

	}

	private void setUpGUI() {
		setUndecorated(true);
		setContentPane(new JLabel(new ImageIcon(getClass().getResource(
				"ComBorder.png"))));
	}

	public OptionScreen() {
		setUpGUI();
		add(installFont());
		add(downloadFont());
		add(back());
		add(done());
		add(resetWD());
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
