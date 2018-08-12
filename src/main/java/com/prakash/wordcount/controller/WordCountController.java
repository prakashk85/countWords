package com.prakash.wordcount.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakash.wordcount.bean.SearchRequest;
import com.prakash.wordcount.bean.SearchResponse;
import com.prakash.wordcount.util.WordCountUtil;

@Controller
@RequestMapping("/counter-api")
public class WordCountController {

	@GetMapping(value = "/top/{count}", produces = "text/csv")
	@ResponseBody
	public String getTopList(@PathVariable("count") int count, HttpServletResponse response) {
		List<Entry<String, Integer>> listEntries = WordCountUtil.getTopList(PARAGRAPH, count);

		StringBuilder sb = new StringBuilder();

		for (Entry<String, Integer> entry : listEntries) {
			sb.append(entry.getKey()).append("|").append(entry.getValue()).append("\n");
		}
		if (sb.toString().endsWith("\n")) {
			sb.setLength(sb.length() - 1);
		}
		return sb.toString();
	}

	@PostMapping(value = "/search", consumes = "application/json")
	@ResponseBody
	public SearchResponse getWordCount(@RequestBody SearchRequest words) {
		Map<String, Integer> mp = WordCountUtil.getWordCountMap(PARAGRAPH, words.getSearchText());
		return new SearchResponse(mp.entrySet());
	}

	private static final String PARAGRAPH = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla sed suscipit metus, sit amet tristique purus. Etiam sit amet\r\n"
			+ "leo sollicitudin, tincidunt lectus vel, ultricies mauris. Donec ultrices lorem in est eleifend, et feugiat libero semper. Duis\r\n"
			+ "sodales gravida sapien eget efficitur. Ut mattis mollis blandit. Duis nec metus gravida, posuere dolor id, pretium urna.\r\n"
			+ "Aliquam vitae purus ex. Etiam vitae ipsum leo. Integer blandit, arcu eget commodo scelerisque, risus leo aliquet diam, in\r\n"
			+ "sagittis metus ex sed elit. Duis vel urna non est fringilla rutrum. Ut molestie sed risus in pharetra. Maecenas eget ante at\r\n"
			+ "nulla feugiat euismod. Suspendisse pharetra porttitor lacus non tristique.\r\n"
			+ "Vivamus varius posuere ligula. Nullam magna metus, elementum vel elementum eu, elementum non magna. Ut cursus\r\n"
			+ "arcu vel ligula mollis, in interdum velit maximus. Pellentesque arcu lorem, porttitor et quam vitae, imperdiet venenatis\r\n"
			+ "magna. Etiam imperdiet erat vel lectus rhoncus sollicitudin. Praesent at mi a est suscipit tempor sed eu diam. In hac\r\n"
			+ "habitasse platea dictumst. Morbi erat mi, iaculis id hendrerit a, sollicitudin et ligula. Vivamus justo nibh, cursus at ultricies\r\n"
			+ "sed, varius iaculis enim.\r\n"
			+ "Donec consequat luctus sapien, quis aliquam ante tristique sit amet. Pellentesque accumsan sollicitudin mi a blandit.\r\n"
			+ "Donec ac dui bibendum, pharetra nulla vitae, iaculis purus. Donec fermentum porttitor mollis. Mauris cursus fringilla ex,\r\n"
			+ "eget ullamcorper ipsum lacinia in. Nam eget vehicula dui. In eget turpis convallis, ultrices neque vitae, interdum turpis.\r\n"
			+ "Nullam non aliquam sapien, eget volutpat elit. Cras pharetra ex a orci faucibus tristique at ullamcorper nibh. Proin nec\r\n"
			+ "lacinia ante, eu rutrum sem.\r\n"
			+ "Curabitur id libero purus. Vivamus vel velit turpis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Donec\r\n"
			+ "at urna eget augue efficitur porttitor at eu elit. Fusce feugiat tempor nulla, at euismod lacus tincidunt sed. Curabitur\r\n"
			+ "ullamcorper dignissim nisl, eget iaculis orci vestibulum sed. Ut consectetur consectetur urna vestibulum ultricies.\r\n"
			+ "Maecenas non felis arcu. Fusce in tortor metus. Vestibulum vel felis ut lorem ultricies pretium quis ut metus. Aliquam erat\r\n"
			+ "volutpat. Praesent a lorem porttitor, venenatis nisl volutpat, placerat dui. Vivamus ut justo eu orci tincidunt malesuada.\r\n"
			+ "Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam facilisis nulla vel leo pretium varius.\r\n"
			+ "Fusce eleifend tincidunt lacinia. Duis maximus, sapien ac fringilla pretium, augue leo aliquam ligula, quis rutrum leo sem\r\n"
			+ "vel magna. Duis commodo lobortis dui, ut rhoncus dolor. Class aptent taciti sociosqu ad litora torquent per conubia nostra,\r\n"
			+ "per inceptos himenaeos. Nam nec augue augue. Quisque eu orci arcu. Aliquam neque odio, eleifend a dolor sed, dapibus\r\n"
			+ "auctor justo. Aliquam sollicitudin arcu sit amet odio gravida, nec viverra nulla efficitur. Phasellus sed libero rutrum lacus\r\n"
			+ "sollicitudin mattis. Sed fermentum sapien ac dolor elementum, quis vehicula sem tempus.\r\n"
			+ "Etiam et orci non orci lobortis dictum id vitae massa. Aenean eu erat nulla. Sed posuere ullamcorper magna, tempor\r\n"
			+ "ultrices justo feugiat rhoncus. Cras fringilla ligula nec euismod tristique. Duis vitae enim eget augue consectetur ultricies.\r\n"
			+ "Nam laoreet sapien at dictum consectetur. Suspendisse tristique purus neque, ut blandit nunc tincidunt et.\r\n"
			+ "Duis pretium condimentum diam id viverra. Pellentesque sit amet dapibus eros, ac auctor lectus. Praesent eget tellus\r\n"
			+ "purus. Proin vel nisl sit amet orci laoreet faucibus eget eu nisi. Nulla id pharetra arcu. Lorem ipsum dolor sit amet,\r\n"
			+ "consectetur adipiscing elit. Vivamus ornare lectus eu metus venenatis, quis porttitor nibh convallis. Nulla nunc metus,\r\n"
			+ "tristique quis dui sed, interdum imperdiet nisl. Vestibulum mattis tincidunt lacus, imperdiet mattis libero varius rhoncus.\r\n"
			+ "Nam in auctor nisl. Nunc tincidunt accumsan pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra,\r\n"
			+ "per inceptos himenaeos. Mauris luctus scelerisque augue, vel finibus ligula semper vel. Lorem ipsum dolor sit amet,\r\n"
			+ "consectetur adipiscing elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.\r\n"
			+ "Nunc ultricies vel nunc eget mollis.\r\n"
			+ "Donec ligula felis, ultrices vel blandit ut, hendrerit vel turpis. Duis faucibus dapibus mi ac semper. Duis id tortor tempus\r\n"
			+ "augue euismod tempus. Integer vehicula velit ut leo blandit sagittis. Vestibulum ante ipsum primis in faucibus orci luctus et\r\n"
			+ "ultrices posuere cubilia Curae; Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis\r\n"
			+ "egestas. Nunc ut urna vel metus molestie venenatis nec non dui. Integer diam metus, aliquam a gravida et, varius id nulla.\r\n"
			+ "Nunc non porttitor ipsum. Aliquam sapien enim, eleifend nec nunc id, tempus tempus ex. Vivamus nec urna ornare,\r\n"
			+ "finibus leo at, posuere urna. Aenean est mi, porta ac gravida at, hendrerit quis elit. Quisque urna mauris, lobortis sit amet\r\n"
			+ "tortor eget, laoreet consectetur tortor. Suspendisse id imperdiet nisl, eget pellentesque tortor. Maecenas sit amet mi et ex\r\n"
			+ "ornare porta sollicitudin vitae tellus. Donec nulla lorem, imperdiet non sodales vitae, congue quis sapien. Quisque nec\r\n"
			+ "mattis lacus. Sed dapibus nisi nec libero ornare, in accumsan dolor porttitor. Praesent sodales commodo ultricies.\r\n"
			+ "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras id ipsum vestibulum,\r\n"
			+ "venenatis eros vitae, maximus magna. Mauris eu blandit tortor, condimentum eleifend dolor.\r\n"
			+ "Cras eu tellus feugiat, lobortis metus ac, consectetur orci. Phasellus bibendum tincidunt massa non venenatis. Nunc sed\r\n"
			+ "molestie metus, vel elementum tortor. Duis malesuada porta nisl ac molestie. In a tellus faucibus, convallis nunc nec,\r\n"
			+ "sodales lacus. Donec vulputate interdum massa sed posuere. In dapibus eu ligula at sodales. Sed facilisis a sem eget\r\n"
			+ "lobortis. Ut viverra ipsum dictum pharetra auctor. Duis tincidunt nulla sapien, sit amet facilisis ante rhoncus eu. Aliquam\r\n"
			+ "luctus dolor tortor, vitae interdum felis elementum eget. Nam mattis leo gravida ex elementum, id facilisis lacus ornare.";
}
