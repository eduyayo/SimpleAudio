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

import static org.junit.jupiter.api.Assertions.fail;

import javax.sound.sampled.Mixer.Info;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import de.ralleytn.simple.audio.AbstractAudio;

@Slf4j
class StaticMethodTest {

	@Test
	public void testGenerateSound() throws InterruptedException {
		int length = 500; // 1/2 sec

		// WITHOUT HARMONY
		AbstractAudio.generateSound(10, length, 100, false);
		Thread.sleep(length); //TODO awaitility??
		AbstractAudio.generateSound(50, length, 100, false);
		Thread.sleep(length);
		AbstractAudio.generateSound(100, length, 100, false);
		Thread.sleep(length);
		AbstractAudio.generateSound(150, length, 100, false);
		Thread.sleep(length);
		AbstractAudio.generateSound(200, length, 100, false);
		Thread.sleep(length);

		// WITH HARMONY
		AbstractAudio.generateSound(10, length, 100, true);
		Thread.sleep(length);
		AbstractAudio.generateSound(50, length, 100, true);
		Thread.sleep(length);
		AbstractAudio.generateSound(100, length, 100, true);
		Thread.sleep(length);
		AbstractAudio.generateSound(150, length, 100, true);
		Thread.sleep(length);
		AbstractAudio.generateSound(200, length, 100, true);
		Thread.sleep(length);
	}
	
	@Test
	public void testGetPorts() {
		Info[] ports = AbstractAudio.getPorts();

		log.info("Print all audio ports...");
		log.info("");
		log.info("===========");

		for(int index = 0; index < ports.length; index++) {

			if(index != 0) {
				log.info("----");
			}

			log.info("Name: {}", ports[index].getName());
			log.info("Vendor: {}", ports[index].getVendor());
			log.info("Version: {}", ports[index].getVersion());
			log.info("Description: {}", ports[index].getDescription());
		}

		log.info("===========");
		log.info("");
			
	}
}
