progressview
============

This project constains panels that views a progress view with some special components (messagelabel, progressbar, cancelbutton, etc.)

In Addition it contains two util classes for the work with the localization support (cancel button in the progress view) and a LoggerUtils for the log4j framework.

I created this class, becaus I don't like to write in every class the following line.

<pre>
private static final Logger logger = Logger.getLogger("SomeClass");

logger.info("Message");
</pre>
The LoggerUtils-class make this simple.
