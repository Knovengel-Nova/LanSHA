# LanSHA

> **Fast, secure and intuitive LAN file sharing built from scratch using Java.**

<p align="center">

<img src="docs/screenshots/banner.png" alt="LanSHA Banner" width="850"/>

</p>

<p align="center">

Automatic Device Discovery • Secure File Transfer • Cross Platform • Open Source

</p>

---

# Overview

Sharing files across devices on the same local network shouldn't require cloud services, internet connectivity or complicated setup.

**LanSHA** is a desktop application that enables fast, reliable and secure file sharing over a Local Area Network (LAN). It automatically discovers nearby devices and transfers files directly between them using custom networking protocols built on top of TCP and UDP.

The project was built to explore the design and implementation of local network communication from first principles while providing a clean and intuitive desktop experience.

---

# Motivation

This project started after studying **Computer Communication & Networking** and **Operating Systems** in my Fourth Semester of Computer Engineering.

Rather than stopping at theoretical concepts, I wanted to implement them in a real application to better understand topics such as:

- TCP & UDP communication
- Socket Programming
- Device Discovery
- Concurrent Network Programming
- Reliable File Transfer
- Software Architecture

LanSHA became the result of that exploration.

---

# Features

### Current

- Automatic LAN device discovery
- Reliable TCP file transfer
- Java Swing interface
- Device management
- File metadata detection
- Multiple simultaneous transfers
- Multiple file type support
- Cross-platform

### Planned

- AES encrypted transfers
- SHA-256 Based Checksum for file integrity
- Resumable downloads
- Drag & Drop
- Transfer history
- Themes

---

# Why LanSHA?

- No internet connection required
- Direct peer-to-peer communication
- Lightweight desktop application
- Designed with modular architecture
- Built entirely from scratch
- Educational implementation of networking concepts

---

# Screenshots

<!-- | Home | Device Discovery |
|------|------------------|
| Image | Image |

| Transfer | Completed |
|----------|-----------|
| Image | Image | -->

---

# Quick Start

## Clone

```bash
git clone https://github.com/Knovengel-Nova/LanSHA.git
```

## Open

Open the project using NetBeans or your preferred Java IDE.

## Run

Execute

```text
LanSHA.java
```

---

# Current Status

Implemented

- [x] UDP Device Discovery
- [x] TCP File Transfer
- [x] Device Registry
- [x] Heartbeat Mechanism
- [x] Desktop UI
- [x] File Metadata
- [x] Multiple Concurrent Transfers
- [ ] AES Encryption
- [ ] Resumable Transfers
- [ ] Themes

---

# Project Architecture

LanSHA follows a modular architecture separating:

- User Interface
- Networking
- Discovery
- Protocol Handling
- File Transfer
- Metadata
- Device Management

A complete explanation of the architecture can be found here:

→ **[Architecture Documentation](docs/architecture.md)**

---

# Documentation

Detailed documentation is available inside the **docs** directory.

| Document | Description |
|----------|-------------|
| [Architecture](docs/architecture.md) | System design and component interactions |
| [Protocol Specification](docs/protocol.md) | Network packet formats and communication flow |
| [Developer Guide](docs/developer-guide.md) | Codebase overview and development guide |
| [Roadmap](docs/roadmap.md) | Planned features and future development |

---

# Roadmap

Upcoming milestones include:

- Secure encrypted transfers
- File integrity verification
- Resume interrupted transfers
- UI improvements
- Performance optimizations

See the complete roadmap:

→ **[Roadmap](docs/roadmap.md)**

---

# Contributing

Contributions, bug reports and feature suggestions are always welcome.

Please read:

→ **[Contributing Guide](docs/contributing.md)**

---

# License

This project is licensed under the MIT License.

See the [LICENSE](LICENSE) file for details.

---

# Connect

If you have suggestions or feedback, feel free to reach out.

GitHub

> https://github.com/Knovengel-Nova

LinkedIn

> https://www.linkedin.com/in/aryanpatil-s/

Email

> knovengel@gmail.com <br>
> aryanpatil7185@gmail.com
