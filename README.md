# Calculator App

Welcome to the Calculator app! This is a simple calculator application designed to help you perform basic arithmetic
operations. Whether you need to add, subtract, multiply, or divide, this app has got you covered. The app features a
straightforward user interface and is built using Java servlets for the backend and a combination of HTML, CSS, and
JavaScript for the frontend.

## Features

- Perform basic arithmetic operations:
    - Addition
    - Subtraction
    - Multiplication
    - Division

## Technologies Used

- Backend: Java Servlets (Jakarta), Tomcat
- Frontend: HTML, CSS, JavaScript

## Getting Started

Follow these simple steps to get the Calculator app up and running on your local machine:

### Setting Up Tomcat

The Calculator app requires Tomcat to be installed and configured on your system. If you do not have Tomcat installed,
please follow these steps:

1. Download Tomcat from the [Apache Tomcat website](https://tomcat.apache.org/download-10.cgi).
2. Set up a User:
    - Open the Tomcat installation directory.
    - Navigate to the `conf` directory.
    - Open the `tomcat-users.xml` file.
    - Add the following lines to the file:
        ```xml
        <user username="user" password="password" roles="manager-gui,manager-script,manager-jmx,manager-status"/>
        ```
    - Save the file.
3. Start Tomcat:
    - Navigate to the Tomcat installation directory.
    - Navigate to the `bin` directory.
    - Run the `startup.sh` script.
    - You can now access the Tomcat Manager by opening a web browser and going to: `http://localhost:8080/manager/html`
4. Setup .m2 settings:
    - Open the .m2 directory in your user directory. ( ```%USERPROFILE%\.m2``` on Windows, ```~/.m2``` on Linux)
    - Open the `settings.xml` file. (If your new to
      Maven, [you may need to create this file](https://www.baeldung.com/maven-settings-xml))
    - Add the following lines to the file:
        ```xml
        <server>
            <id>TomcatServer</id>
            <username>user</username>
            <password>password</password>
        </server>
        ```

### Deploying the App

1. Clone the repository: `git clone https://github.com/Joel-Schaltenbrand/CalculatorNoSpring.git`
2. Navigate to the repository directory: `cd Calculator`
3. Deploy the app using Tomcat:
    - Ensure you have Tomcat started
    - Deploy the app by typing `mvn tomcat7:deploy` in the terminal.
    - You can access the app by opening a web browser and going to: `http://localhost:8080/Calculator`

## Contributing

We welcome contributions from the community! If you'd like to contribute to the Calculator app, please follow these
steps:

1. Fork the repository.
2. Make your changes and improvements.
3. Submit a pull request.

## License

This project is licensed under the MIT License. For more details, please refer to the [LICENSE](LICENSE.md) file.
