import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_tts/flutter_tts.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Exercise 3',
      home: MyHomePage(title: 'Exercise 3'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<dynamic> articles = [];
  late FlutterTts flutterTts;
  late ScrollController _scrollController;

  Future<void> fetchNews() async {
    try {
      String apiUrl =
          'https://newsapi.org/v2/everything?q=apple&from=2024-04-25&to=2024-04-25&sortBy=popularity&apiKey=0f303bb99c104d6893ffc040e899bf60';

      final response = await http.get(Uri.parse(apiUrl));
      if (response.statusCode == 200) {
        final jsonData = jsonDecode(response.body);
        setState(() {
          articles.addAll(jsonData['articles']);
        });
      } else {
        throw Exception('Failed to load news: ${response.statusCode}');
      }
    } catch (e) {
      print('Error fetching news: $e');
      // Handle error, e.g., display a message to the user
    }
  }

  @override
  void initState() {
    super.initState();
    fetchNews();
    flutterTts = FlutterTts();
    _scrollController = ScrollController();
    _scrollController.addListener(() {
      if (_scrollController.position.pixels ==
          _scrollController.position.maxScrollExtent) {
        fetchNews();
      }
    });
  }

  Future<void> speakArticle(String text) async {
    await flutterTts.setLanguage('en-US');
    await flutterTts.setPitch(1);
    await flutterTts.speak(text);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: Text(
          widget.title,
          style: const TextStyle(
              color: Colors.white, fontSize: 40),
        ),
      ),
      backgroundColor: const Color.fromARGB(255, 175, 174, 174),
      body: ListView.builder(
        controller: _scrollController,
        itemCount: articles.length,
        itemBuilder: (context, index) {
          final article = articles[index];
          return Column(
            mainAxisAlignment: MainAxisAlignment.center,
            // crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Image.network(
                article['urlToImage'] ?? '',
                width: 500,
                height: 300,
              ),
              Text(
                article['title'] ?? '',
                style: const TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold, 
                  fontSize: 30
                ),
              ),
              Text(
                article['description'] ?? '',
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 15
                ),
              ),
              Text(
                'Written by: ${article['author'] ?? ''}',
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 12
                ),
              ),
              const SizedBox(width: 10),
              Text(
                'Publish date: ${article['publishedAt'] ?? ''}',
                style: const TextStyle(
                  color: Colors.white,
                  fontSize: 12
                ),
              ),
              const Divider(height: 12, thickness: 2, color: Colors.white,),
            ],
          );
        },
      ),
    );
  }
}