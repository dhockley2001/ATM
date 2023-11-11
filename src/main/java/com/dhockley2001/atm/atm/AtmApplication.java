package com.dhockley2001.atm.atm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhockley2001.atm.atm.models.User;
import com.dhockley2001.atm.atm.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AtmApplication {


	@Autowired
	private UserService userService;
	private static final Logger logger = LogManager.getLogger("ATMApplication");
	private static final String FONT_NAME = "Tahoma";

	@PostConstruct
	public void initUI() {
		List<User> users = userService.getAllUsers();
		int nextAccountNumber = 1000000;

		if (users.isEmpty()) {
			nextAccountNumber = 1000000;
		} else {
			nextAccountNumber = users.size() + 1000001;
		}
		logger.info("Completed UI initialisation. Received {} users.", users.size());
		// new Login(users, nextAccountNumber);
	}

	public static JFrame Frame(int width, int height) {
		JFrame frame = new JFrame("ATM");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.white);
		return frame;
	}

		public static JLabel Label(String text, int size) {
		JLabel label = new JLabel(text);
		label.setFont(new Font(FONT_NAME, Font.BOLD, size));
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
	
	public static JTextField TextField(int size) {
		JTextField textField = new JTextField();
		textField.setFont(new Font(FONT_NAME, Font.BOLD, size));
		textField.setForeground(Color.black);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		return textField;
	}
	
	public static JPasswordField PasswordField(int size) {
		JPasswordField passField = new JPasswordField();
		passField.setFont(new Font(FONT_NAME, Font.BOLD, size));
		passField.setForeground(Color.black);
		passField.setHorizontalAlignment(SwingConstants.CENTER);
		return passField;
	}
	
	public static JButton Button(String text, int size) {
		JButton btn = new JButton(text);
		btn.setFont(new Font(FONT_NAME, Font.BOLD, size));
		btn.setForeground(Color.white);
		btn.setBackground(Color.black);
		btn.setHorizontalAlignment(SwingConstants.CENTER);
		btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		return btn;
	}

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

}
