/*
 * MIT License
 * 
 * Copyright (c) 2017 Ralph Niemitz
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.ralleytn.simple.audio.tests;

import de.ralleytn.simple.audio.Audio;
import de.ralleytn.simple.audio.AudioEvent;
import de.ralleytn.simple.audio.AudioException;
import de.ralleytn.simple.audio.BufferedAudio;
import de.ralleytn.simple.audio.StreamedAudio;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayTest {
	
	private static void testAudio(Audio audio) throws AudioException, InterruptedException {
		
		audio.open();
		audio.addAudioListener(event -> {
			if (event.getType() == AudioEvent.Type.REACHED_END) {
				assertTrue(audio.isOpen());
				audio.close();
			}
		});
		audio.play();

		Thread.sleep(audio.getLength() + 200);
			
		assertFalse(audio.isOpen());
	}
	
	private static void test(String name) throws AudioException, InterruptedException {
		URL resource = Sources.getResource(name);
		testAudio(new BufferedAudio(resource));
		testAudio(new StreamedAudio(resource));
	}
	
	@Test
	void test() throws AudioException, InterruptedException {
		test("audio.aifc");
		test("audio.aiff");
		test("audio.au");
		test("audio.wav");
		test("audio.mp3");
		test("audio.ogg");
		test("audio.snd");
	}

}
