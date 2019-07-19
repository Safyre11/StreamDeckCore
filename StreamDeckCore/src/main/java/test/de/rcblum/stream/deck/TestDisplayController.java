package test.de.rcblum.stream.deck;

import java.io.IOException;

import de.rcblum.stream.deck.StreamDeckController;
import de.rcblum.stream.deck.device.general.IStreamDeck;
import de.rcblum.stream.deck.device.hid4java.StreamDeckDevices;
import de.rcblum.stream.deck.items.FolderItem;
import de.rcblum.stream.deck.items.StreamItem;

public class TestDisplayController {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("log4j.configurationFile",
				TestAnimationStack.class.getResource("/resources/log4j.xml").getFile());
		IStreamDeck sd = StreamDeckDevices.getStreamDeck();
		sd.init();
		sd.reset();
		sd.setBrightness(5);
		StreamItem[] items = new StreamItem[15];
		FolderItem root = new FolderItem("Testfolder", null, items);

		StreamDeckController controller = new StreamDeckController(sd, root);
		Thread.sleep(2000);
		controller.stop(true, true);
		System.exit(0);
	}
}
