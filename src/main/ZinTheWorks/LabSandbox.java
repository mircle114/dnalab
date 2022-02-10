/* _____________________________________________________________________________________________

LinkedHashMap<String,Double> combos = getCombos();
     List<Integer[]> keys = combos.keySet().stream()
        .map(k -> 
        { 
            // Strip out any unwanted chars
            String newK = k.replace("[","").replace("]","");
            // Our String Array
            String[] newStringArray = newK.split(","); 
            // *************Good conversion examples with Stream class ***************
            // ********* int[] -> IntStream -> Stream<Integer> -> Integer[] **********
            // int[] -> IntStream : Get array of primitive ints from the String Array
            int[] primitiveInts = Arrays.stream(newStringArray).map(String::trim).mapToInt(Integer::parseInt).toArray();
            
            
            // 1. int[] --> IntStream
            IntStream intStream = Arrays.stream(primitiveInts);
            // 2. IntStream --> Stream<Integer>
            Stream<Integer> boxedIntegerStream = intStream.boxed();
            // 3. Stream<Integer> --> Integer[]
            Integer[] integerArray = boxedIntegerStream.toArray(Integer[]::new);

            // THE ONE LINER to get an Integer[] out of a int primitive array
            Integer[] oneLinerIntegerArray = Arrays.stream(primitiveInts).boxed().toArray(Integer[]::new);
            return oneLinerIntegerArray; 
        })   
        .collect(Collectors.toList());

__________________________________________________________________________________________________________________________________________________________________________________________

    // How to get a set from a generic list
    Set<String> targetSet = new HashSet<>(listDnaResults);


 // Collect the list as map by groupingBy() method
        Map<String,Long> resultDivMap
 = listResults.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

 More cools examples 
 
   List<Integer> list = Arrays.asList(string.split("")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
   
    List<Integer> plus = list.stream().filter(index, n -> index == 2).collect(Collectors.toList());
            //List<Integer> plus = list.stream().mapToObj(index -> index < 3).collect(Collectors.toList());
            //IntStream intStream  = list.stream().flatMapToInt(IntStream::of);
            //List<String> plus = intStream.limit(2).mapToObj(num -> Integer.toString(num)).collect(Collectors.toList());
            //Integer sum = list.stream().filter(i -> i > 0).mapToInt(i -> i).sum();
            //out.println(myList.stream().map(Number.class::cast).mapToInt(Number::intValue).sum());
            //Integer sum = intArray.stream.filter(Number.class::isInstance).map(Number.class::cast).mapToInt(Number::intValue).sum();
            /*    int[] ints = Arrays.stream(objects)
                    .filter(Number.class::isInstance)
                    .map(Number.class::cast)
                    .mapToInt(Number::intValue)
                    .toArray();
                    */
//_____________________________________________________________________________________________





//create the font*/
/*
try {
    //create the font to use. Specify the size!
    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts\\custom_font.ttf")).deriveFont(12f);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //register the font
    ge.registerFont(customFont);
} catch (IOException e) {
    e.printStackTrace();
} catch(FontFormatException e) {
    e.printStackTrace();
}

//use the font
yourSwingComponent.setFont(customFont);

GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("A.ttf")));

*/


/* 

// Use this code to help build a JOB runner
https://www.javamex.com/tutorials/threads/invokelater.shtml




*/