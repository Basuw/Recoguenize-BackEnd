# Recoguenize

This application aims to to identify the name of a song you're hearing like the famous app Shazam.

## Context

This project was realised during 1st year of engineering school in computer science at *ISIMA* (equivalent to master in engineering)

## Languages / frameworks

- SpringBoot 3 🍃
- Flutter 📱
- Python 🐍
- PostgreSQl 💾
- Docker 📦

## User Guide for the Recoguenize App

This app is designed to identify the name of a song recorded using the phone's microphone.

### Available Songs

The app is configured to recognize three different songs:

1. Thunderstruck by AC/DC
2. Houdini by Eminem
3. Gitano by Kendji Girac

Only the first minute of each song is recorded in the database. Therefore, the app can only recognize the first minute of the above songs.

### Installing the Mobile App

To install the app on your smartphone (available on Android only), follow these instructions:

1. Download the `app-debug.apk` file from the [Git repository](https://gitlab.isima.fr/sae1.shazaaam/recoguenize-backend).
2. Your smartphone may block the installation of the app. To resolve this, make sure that in your phone settings, the "My Files" option is checked under the "Install unknown apps" section.
3. Connect your smartphone to the computer and copy the `.apk` file to your phone's files.
4. On your smartphone, launch the `.apk` file.
5. The "IP address" section is only necessary if you are installing the app locally as described below.

### Installing the Server Locally

> :exclamation: If the response time is unusually long, it means that the virtual machine is experiencing issues.

The app's server is hosted on an Azure virtual machine. Since this may encounter technical issues beyond our control, here is a guide to installing the app locally. It is necessary that both the smartphone and the computer used to launch the app are on the same Wi-Fi network.

1. Clone the Git repository:

    ```bash
    git clone https://gitlab.isima.fr/sae1.shazaaam/recoguenize-backend.git
    ```

2. Start Docker:

    ```bash
    cd recoguenize-backend
    docker-compose up 
    ```

3. After about a minute, the server will be started and ready to use.

4. To connect your smartphone to the local server, enter your IP address in the designated section of the app.

5. To find your IP address, open a command prompt on your computer, type `ipconfig`, and enter the value from the "IPv4 Address" field under the "Wireless LAN adapter Wi-Fi" section into the app.

## Others

You can find the repository of the Mobile app📲 by this [link](https://github.com/Basuw/Recoguenize-App). 😃

## Authors

- Guillhot Alban
- Imbert Antoine
- Louis Cambier
- Yoan Boyer
- Bastien Jacquelin
