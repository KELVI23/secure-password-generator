# Secure Password Generator

This Java-based application generates random, secure passwords and stores their encrypted versions securely. It offers an intuitive Swing-based graphical user interface (GUI) for seamless interaction.

## Features

- **Secure Password Generation**: Creates strong, random passwords to enhance security.
- **Password Encryption**: Encrypts generated passwords before storage to ensure confidentiality.
- **User Authentication**: Includes an admin login system for authorized access.
- **Swing GUI**: Provides a user-friendly interface for easy operation.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed on your system.
- **Log4j Library**: Required for logging functionalities.
- **MigLayout Library**: Used for flexible and efficient Swing layouts.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/KELVI23/secure-password-generator.git
   ```

2. **Add External Libraries**:
   - Include the following JAR files in your project's build path:
     - `log4j-api-2.10.0.jar`
     - `log4j-core-2.10.0.jar`
     - `miglayout15-swing.jar`

3. **Build and Run the Application**:
   - Open the project in your preferred Java IDE.
   - Build the project to resolve dependencies.
   - Run the `Main` class to launch the application.

## Usage

- **Admin Login**: Access the application using the credentials stored in `adminLogInDetails.txt`.
- **Generate Passwords**: Use the GUI to generate secure passwords.
- **Store Passwords**: Encrypted passwords are stored securely within the application.

## Project Structure

- **Source Code**: Located in the `src` directory.
- **Libraries**: External libraries are included in the root directory.
- **Resources**: Configuration files and admin login details are in the root directory, including:
  - `adminLogInDetails.txt`

## Dependencies

- **Log4j 2.10.0**: For logging purposes.
- **MigLayout**: For advanced layout management in Swing.

## Notes

- **Security**: Ensure that the `adminLogInDetails.txt` file is stored securely to prevent unauthorized access.
- **Logging**: Log configurations are managed via Log4j.

## License

This project is open-source. Feel free to modify and use it according to your needs.

---

*For any issues or contributions, please refer to the repository on [GitHub](https://github.com/KELVI23/secure-password-generator).* 
