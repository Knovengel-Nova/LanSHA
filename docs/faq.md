# Frequently Asked Questions (FAQ)

**Navigation**

[README](../README.md) •
[Architecture](architecture.md) •
[Protocol Specification](protocol.md) •
[Developer Guide](developer-guide.md) •
FAQ

---

# General

## What is LanSHA?

LanSHA is a desktop application that enables peer-to-peer file sharing over a Local Area Network (LAN). It automatically discovers nearby devices and transfers files directly without requiring an internet connection or cloud service.

---

## Why the name "LanSHA"?

The name **LanSHA** combines:

- **LAN** – Local Area Network
- **SHA** – Originally chosen to represent secure and reliable file transfer, with future plans to incorporate SHA-256 based integrity verification.

The name reflects the project's focus on networking while leaving room for future security enhancements.

---

## Why was LanSHA built?

LanSHA was developed to apply concepts from Computer Networks and Operating Systems in a practical project.

Rather than relying on existing file-sharing frameworks, the goal was to understand how LAN communication, socket programming, protocol design, concurrency and file transfer work by implementing them from scratch.

---

## What technologies does LanSHA use?

- Java
- Java Swing
- TCP
- UDP
- Jackson (JSON Serialization/Deserialization)
- Maven

---

# Networking

## Why does LanSHA use both TCP and UDP?

Each protocol is used according to its strengths.

- **UDP** is used for lightweight discovery and presence management.
- **TCP** is used for reliable file transfer.

This separation keeps the protocol efficient while ensuring reliable data transmission.

---

## Why not use only TCP?

TCP does not support broadcasting, which is essential for automatically discovering devices on a LAN.

Using UDP for discovery avoids unnecessary connection establishment while allowing devices to locate each other efficiently.

---

## Why is UDP used only for discovery and heartbeats?

Discovery and heartbeat packets are lightweight status messages.

Occasional packet loss is acceptable because:

- Discovery occurs when a device starts.
- Heartbeats are transmitted periodically.
- Missing devices are eventually rediscovered or removed through timeout mechanisms.

Reliable delivery is unnecessary for these packets.

---

## Why is TCP used for file transfer?

File transfers require:

- Reliable delivery
- Ordered delivery
- Automatic retransmission
- Flow control

These guarantees are already provided by TCP, making it well suited for transferring files.

---

## Why implement a custom protocol?

The primary goal of LanSHA is educational.

Implementing a custom application-layer protocol provides a deeper understanding of:

- Packet design
- Socket programming
- Network communication
- Protocol architecture
- File transfer mechanisms

---

# Protocol

## Why does every packet inherit from a common Packet class?

All packets share common information such as:

- Packet type
- Device UUID
- Device name
- TCP port

Using a shared base class eliminates duplicate code while ensuring a consistent protocol structure.

---

## Why use UUID instead of IP addresses?

IP addresses may change due to DHCP or network configuration changes.

UUIDs uniquely identify a device regardless of its current network address.

---

## Why serialize packets as JSON?

JSON offers several advantages:

- Human readable
- Easy debugging
- Easy protocol extension
- Excellent Jackson support

Although binary protocols are more compact, JSON simplifies development and debugging.

---

## Why use application-level ACK packets when TCP already provides acknowledgements?

TCP acknowledgements guarantee reliable transport.

LanSHA acknowledgements operate at the application level and are used to:

- Track transfer progress
- Synchronize sender and receiver
- Support future resumable transfers
- Update the user interface

---

## Why transfer files in chunks?

Chunk-based transfers:

- Reduce memory usage
- Allow progress tracking
- Scale better for large files
- Provide a foundation for resumable transfers

---

# Architecture

## Why separate networking and protocol packages?

Networking components manage communication over sockets.

Protocol components define the structure of packets being exchanged.

Separating these responsibilities improves maintainability and modularity.

---

## Why separate TransferManager, TransferSender and TransferReceiver?

Each class has a single responsibility.

- **TransferManager** coordinates transfers.
- **TransferSender** sends file data.
- **TransferReceiver** receives file data.

This separation keeps the networking layer modular and easier to maintain.

---

## What does the Janitor service do?

The Janitor periodically removes inactive devices from the Device Registry.

If heartbeat packets are not received within the configured timeout period, the corresponding device is automatically removed.

---

## Why use PacketSerializer?

PacketSerializer centralizes all serialization logic.

It converts Java packet objects into JSON before transmission and reconstructs packet objects after reception.

Keeping serialization in a single location simplifies protocol maintenance.

---

# Security

## Are file transfers encrypted?

Not currently.

Encryption is planned for a future release using AES.

---

## How will file integrity be verified?

Future versions will introduce SHA-256 checksums to verify that transferred files have not been corrupted or modified.

---

## Does LanSHA require an internet connection?

No.

LanSHA communicates entirely within the local network.

---

# Future Development

## What features are planned?

Planned features include:

- AES encrypted transfers
- SHA-256 file integrity verification
- Resumable transfers
- Drag-and-drop support
- Transfer history
- Additional UI themes

---

## Could LanSHA work over the internet?

The current implementation is designed specifically for Local Area Networks.

Supporting internet-based transfers would require additional features such as:

- Authentication
- NAT traversal
- Relay servers
- Secure encrypted communication

---

## Why use Java Swing instead of JavaFX?

The project currently uses Swing because it provides a mature desktop toolkit and aligns well with the project's goals.

Future desktop technologies may be explored as the project evolves.

---

# Contributing

## Can I contribute?

Absolutely.

Suggestions, bug reports and pull requests are always welcome.

Please follow the existing coding style and update documentation whenever protocol or architectural changes are introduced.

---

# Additional Documentation

- [Architecture](architecture.md)
- [Protocol Specification](protocol.md)
- [Developer Guide](developer-guide.md)

---

If your question is not answered here, feel free to open an issue or start a discussion on GitHub.