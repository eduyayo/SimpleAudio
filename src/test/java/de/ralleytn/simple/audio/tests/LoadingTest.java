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
import de.ralleytn.simple.audio.AudioException;
import de.ralleytn.simple.audio.BufferedAudio;
import de.ralleytn.simple.audio.StreamedAudio;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class LoadingTest {
	
	private static void testAudio(Audio audio) throws AudioException {
		
		audio.open();
		audio.close();
	}
	
	// ==== BUFFERED
	private static void loadBufferedFromURL(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getURL()));
		log.info("Name: {}, Source: URL, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromURI(Sources sources) throws AudioException, URISyntaxException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getURI()));
		log.info("Name: {}, Source: URI, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromFile(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getFile()));
		log.info("Name: {}, Source: File, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromFileName(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getFileName()));
		log.info("Name: {}, Source: File Name, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromPath(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getPath()));
		log.info("Name: {}, Source: Path, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromZipFile(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getZipFile(), sources.getName()));
		log.info("Name: {}, Source: ZIP File, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromZipFileName(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getZipFileName(), sources.getName()));
		log.info("Name: {}, Source: ZIP File Name, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadBufferedFromZipPath(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new BufferedAudio(sources.getZipPath(), sources.getName()));
		log.info("Name: {}, Source: ZIP Path, Mode: buffered, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void testBuffered(Sources sources) throws AudioException, URISyntaxException, IOException {

		loadBufferedFromURL(sources);
		loadBufferedFromURI(sources);
		loadBufferedFromFile(sources);
		loadBufferedFromFileName(sources);
		loadBufferedFromPath(sources);
		loadBufferedFromZipFile(sources);
		loadBufferedFromZipFileName(sources);
		loadBufferedFromZipPath(sources);
	}
	
	// ==== STREAMED
	
	private static void loadStreamedFromURL(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getURL()));
		log.info("Name: {}, Source: URL, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromURI(Sources sources) throws AudioException, URISyntaxException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getURI()));
		log.info("Name: {}, Source: URI, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromFile(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getFile()));
		log.info("Name: {}, Source: File, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromFileName(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getFileName()));
		log.info("Name: {}, Source: File Name, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromPath(Sources sources) throws AudioException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getPath()));
		log.info("Name: {}, Source: Path, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromZipFile(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getZipFile(), sources.getName()));
		log.info("Name: {}, Source: ZIP File, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromZipFileName(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getZipFileName(), sources.getName()));
		log.info("Name: {}, Source: ZIP File Name, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void loadStreamedFromZipPath(Sources sources) throws AudioException, IOException {
		
		long startTime = System.currentTimeMillis();
		testAudio(new StreamedAudio(sources.getZipPath(), sources.getName()));
		log.info("Name: {}, Source: ZIP Path, Mode: streamed, Time: {} ms", sources.getName(), System.currentTimeMillis() - startTime);
	}
	
	private static void testStreamed(Sources sources) throws AudioException, URISyntaxException, IOException {

		loadStreamedFromURL(sources);
		loadStreamedFromURI(sources);
		loadStreamedFromFile(sources);
		loadStreamedFromFileName(sources);
		loadStreamedFromPath(sources);
		loadStreamedFromZipFile(sources);
		loadStreamedFromZipFileName(sources);
		loadStreamedFromZipPath(sources);
	}
	
	private static void test(String name) throws AudioException, URISyntaxException, IOException {
		Sources sources = new Sources(name);
		testBuffered(sources);
		testStreamed(sources);
			
	}
	
	@Test
	public void test() throws AudioException, URISyntaxException, IOException {
		
		log.info("Start loading tests...");
		log.info("");
		log.info("==========");

		test("audio.aifc");
		test("audio.aiff");
		test("audio.au");
		test("audio.wav");
		test("audio.mp3");
		test("audio.ogg");
		test("audio.snd");
		assertThrows(AudioException.class, () -> test("audio.aac"));
		assertThrows(AudioException.class, () -> test("audio.wma"));
		assertThrows(AudioException.class, () -> test("audio.flac"));
		
		log.info("==========");
		log.info("");
	}

}
