import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//@test1

public class Test1 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		getNames();
		nameStream();
		nameInt();
	}

	public static void getNames() {

		ArrayList<String> namesList = new ArrayList<String>();
		namesList.add("kittu");
		namesList.add("evwd");
		namesList.add("qefef");
		namesList.add("ewrvce");

		int count = 0;

		for (int i = 0; i < namesList.size(); i++) {

			String name = namesList.get(i);
			if (name.startsWith("e")) {
				count++;

			}

		}
		System.out.println(count);
	}

	// streams example

	public static void nameStream() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("kittu");
		names.add("evwd");
		names.add("qefef");
		names.add("ewrvce");

		Long streamName = names.stream().filter(s -> s.startsWith("e")).count();
		System.out.println(streamName);

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// names.stream().filter(s->s.length()>4).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		List<String> alist = Arrays.asList("kittu", "evwb", "adcsdcv", "efrwgrb", "efecvb", "QEFIJEWVE", "EFRWETYRE",
				"WEFWGRBFDE");

		alist.stream().filter(s -> s.endsWith("b")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		System.out.println("............................................................");
		alist.stream().filter(s -> s.endsWith("E")).map(s -> s.toLowerCase()).forEach(s -> System.out.println(s));
	}
	// @test2

	public static void nameInt() {

		List<Integer> num = Arrays.asList(2, 3, 5, 6, 8, 3, 3, 3, 3, 1, 34);
		num.stream().distinct().forEach(s -> System.out.println(s));
		num.stream().sorted().distinct().forEach(s -> System.out.println(s));

		List<Integer> num1 = num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("..................");
		System.out.println(num1.get(2));

	}

}
