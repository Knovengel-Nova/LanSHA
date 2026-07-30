# FAQ

## What is LanSHA?

LanSHA is a Java desktop application for sharing files directly between devices on the same local network. It discovers nearby devices automatically and uses a custom protocol to coordinate transfers without depending on the internet or a cloud service.

## Why does LanSHA use both UDP and TCP?

UDP is used for lightweight discovery and heartbeat traffic because it supports broadcast-based communication without requiring a connection. TCP is used for file transfer because it provides reliable, ordered delivery for data payloads.

## Is the transfer protocol secure today?

The current implementation focuses on reliable LAN transfer rather than full end-to-end encryption. AES-based security work is planned, but it is not yet part of the main implementation.

## How are packets serialized?

LanSHA serializes its packets to JSON using Jackson. This keeps the protocol human-readable and easier to debug while still supporting a straightforward network workflow.

## What kind of files can be sent?

The UI and metadata support include common document, image, audio, and video file types. The transfer layer itself is file-agnostic and can carry any file payload that is selected by the user.

## Does the project depend on any external services?

No. LanSHA is designed to work entirely on the local network and does not require an internet connection or a central server.

## Where can I find the architecture diagrams?

The visual reference assets are stored in [docs/Images](Images). They include overview diagrams for the architecture, protocol hierarchy, packet format, and runtime communication flow.

## Can I contribute?

Yes. The project is a good fit for contributions around networking, UI improvements, transfer reliability, and protocol evolution.


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