# CIS2702-Development-Container

A Visual Studio based Development Container for **CIS2702**.

![Status - 2025-2026 Module Ready](https://img.shields.io/badge/Status-2025--2026_Module_Prep-2ea44f)

![Supported On* - Windows, MacOS and Linux Distributions](https://img.shields.io/badge/Supported_On*-Windows_|_MacOS_|_Linux_Distributions-F43c91)

![Architectures - x86 | AMD64 | ARM](https://img.shields.io/badge/Architectures-x86_|_AMD64_|_ARM-953cf4)

## Technologies

The following technologies are used:

[![Platform - Docker](https://img.shields.io/badge/Platform-Docker-0db7ed)](https://www.docker.com/products/docker-desktop/)  [![IDE - Visual Studio Code](https://img.shields.io/badge/IDE-Visual_Studio_Code-00A3EE)](https://code.visualstudio.com/download) [![OS - Ubuntu 22.04 LTS](https://img.shields.io/badge/OS-Ubuntu_22.04_LTS-E95420)](https://ubuntu.com/blog/tag/22-04-lts)

### Docker

Is a platform for developing, shipping, and running applications in lightweight, portable containers. Containers package an application and its dependencies, ensuring it runs consistently across environments—whether on a developer’s laptop, a test server, or in production.

### Visual Studio Code

(VS Code) is a lightweight, open-source code editor developed by Microsoft. It’s designed for modern development workflows, offering built-in support for multiple programming languages, debugging, and version control.

### Ubuntu 22.04 LTS

Ubuntu 22.04 (Jammy Jellyfish) is a long-term support (LTS) release of the popular Linux distribution, supported until April 2027. It’s designed for both desktop and server use, combining stability, performance, and modern features.

## Requirements

You will be required to install the following on your system in the order listed below. Click the links and follow the instructions for your operating system.

1. [Docker Desktop](https://www.docker.com/products/docker-desktop/)
2. [Visual Studio Code](https://code.visualstudio.com/)
3. [Dev Containers Visual Studio Code Extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)

## About: Dev Environment

The development environment contains the base development configuration for **CIS2702** which has been configured for developing Java applications using OpenJDK 21+. 

## Extensions and Settings

The following Visual Studio Code Extensions are installed by default with the development container.

- Oracle.oracle-java
- vscjava.vscode-java-pack

## Deploying the Development Container

Visual Studio Code. If the extensions have been installed correctly you should see an icon in the bottom left, this is the Remote-View. Press this icon and the action menu will appear, select the option Open folder in Container. Navigate to where the extracted the directory earlier and press open.

![Deploying the Development Container](https://github.com/Edge-Hill-University-Web/Module-Resources/blob/main/CIS2373-Deploy.gif?raw=true "CIS2723 Development Container Deployment")

You should see something similar happen in the animation above. Essentially, this is automatically configuring your development environment for you!

## Getting Started with Visual Studio Code

Below is a getting started YouTube Video provided by Microsoft Visual Studio Code.

[![Getting Started with VS Code](https://img.youtube.com/vi/B-s71n0dHUk/0.jpg)](https://www.youtube.com/watch?v=B-s71n0dHUk)

### FAQ

For this module there is no escaping the use of Command line tools (CLI tools).  Below are some that you will need to familiarise your self with:

- mvn
- zip
- unzip
- git