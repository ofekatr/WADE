# WADE
Widget Applications Display Engine.

A basic widget manager application. Users can configure multiple widgets to display on their screens. Initially developed for Raspberry Pi. Ultimately can be expanded and designed to run on any display. Widgets provide and receive different formats of live data – provided via TCP/IP communication.

The project’s architecture is based on the Client-Server pattern. Client side – focuses on presentation of widgets and their relevant data, while server side is responsible for producing the said data. That way, alternating data polling implementations becomes cleaner and is managed only on server side.
# Please view the projects slides summary found among its files.

Once running, the client side parses a configuration file. The file details the requested widgets that the user wishes to display. The number of widgets that can be displayed at once is limited.

Currently user interface is terminal-based. Data updates are displayed evey short interval of time.

Running instructions: 

– Requires adding the following libraries: JSON, OkHttp3.

– Program receives 1 of 2 possibe arguments: --server, --client .

![Runtime Example](https://user-images.githubusercontent.com/46415136/80614248-e4d92000-8a46-11ea-9cc4-b56eb297e86c.jpeg)
