package util;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayCompare {
	private List<String> left;
	private List<String> right;

	public ArrayCompare (List<String> left, List<String> right) {
		this.left = left;
		this.right = right;
	}

	public List<String> intersection () {
		return intersection(false);
	}

	public List<String> intersection (boolean caseSensitive) {
		List<String> rightStream = this.right
				.stream()
				.map(entry -> caseSensitive ? entry : entry.toLowerCase())
				.collect(Collectors.toList());

		return this.left
				.stream()
				.map(entry -> caseSensitive ? entry : entry.toLowerCase())
				.filter(rightStream::contains)
				.collect(Collectors.toList());
	}
}