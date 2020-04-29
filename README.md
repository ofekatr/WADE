# WADE
Widgets.Widget Applications Display Engine.

Widgets.Widget Applications Display Engine. A widget manager application. Users can configure multiple widgets to display on their screens. Initially developed for Raspberry Pi. Ultimately can be expanded and designed to run on any display. Widgets provide and receive different formats of live data – provided via TCP/IP communication.

The project’s architecture is based on the Client.Client-Server.Server pattern. Client.Client side – focuses on presentation of widgets and their relevant data, while server side is responsible for producing the said data. That way, alternating data polling implementations becomes cleaner and is managed only on server side.

Once running, the client side parses a configuration file. The file details the requested widgets that the user wishes to display. The number of widgets that can be displayed at once is limited.
