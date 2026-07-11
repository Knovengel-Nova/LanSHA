# LanSHA

<p align="center">
<strong>Fast, lightweight and secure LAN file sharing built from scratch.</strong>
</p>

<p align="center">
<img src="docs/screenshots/banner.png" alt="LanSHA Banner" width="850"/>
</p>

<p align="center">
Automatic Device Discovery • TCP/UDP • Java • Cross Platform
</p>

---

# Overview

Sharing files across devices on the same local network shouldn't require cloud services, internet connectivity or complicated setup.

**LanSHA** is a desktop application that enables fast, reliable and secure file sharing over a Local Area Network (LAN). It automatically discovers nearby devices using UDP broadcasts and transfers files reliably over TCP connections using custom Application layer Protocols.

The project was built to explore the design and implementation of local network communication from first principles while providing a clean and intuitive desktop experience.

---

# Motivation

This project started after studying **Computer Communication & Networking** and **Operating Systems**.

Rather than stopping at theoretical concepts, I wanted to apply them by building a real-world networking application from scratch.


- TCP & UDP communication
- Socket Programming
- Device Discovery
- Concurrent Network Programming
- Reliable File Transfer
- Software Architecture

LanSHA became the result of that exploration.

---

# Features

### Current Features

- Automatic LAN device discovery
- Reliable TCP file transfer
- Java Swing interface
- Device management
- File metadata detection
- Multiple simultaneous transfers
- Multiple file type support
- Cross-platform

### Planned Features

- AES encrypted transfers
- SHA-256 Based Checksum for file integrity
- Resumable downloads
- Drag & Drop
- Transfer history
- Themes

---

# Why LanSHA?

- Automatic device discovery
- No internet connection required
- Direct peer-to-peer communication
- Reliable TCP transfers
- Cross-platform
- Modular architecture
- Built entirely from scratch

---

# Screenshots

> Screenshots will be added after the first stable release.

---

# Quick Start

## Requirements

- Java 23+
- Maven
- NetBeans (recommended)

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
<!-- TODO add Architecture Diagram -->

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

Contributions, bug reports, feature requests and general feedback are always welcome.

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
