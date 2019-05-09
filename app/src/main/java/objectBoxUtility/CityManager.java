package objectBoxUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import datadb.Attraction;
import datadb.City;
import datadb.City_;
import datadb.Kind;
import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CityManager {

    private Box<City> cityBox;
    private AttractionManager attractionManager;
    private KindManager kindManager;

    public CityManager(BoxStore boxStore){
        this.cityBox = boxStore.boxFor(City.class);
        this.attractionManager = new AttractionManager(boxStore);
        this.kindManager = new KindManager(boxStore);
    }

    /*Questo metodo è enorme. Lascialo chiuso, fidati.*/
    public void init(){
        City c;
        //Rome
        c = new City();
        c.name = "Rome";
        c.description = "Rome (Latin and Italian: Roma [ˈroːma]) is the capital city and a special comune of Italy (named Comune di Roma Capitale). Rome also serves as the capital of the Lazio region. With 2,872,800 residents in 1,285 km2 (496.1 sq mi), it is also the country's most populated comune. It is the fourth most populous city in the European Union by population within city limits. It is the centre of the Metropolitan City of Rome, which has a population of 4,355,725 residents, thus making it the most populous metropolitan city in Italy. Rome is located in the central-western portion of the Italian Peninsula, within Lazio (Latium), along the shores of the Tiber. The Vatican City (the smallest country in the world) is an independent country inside the city boundaries of Rome, the only existing example of a country within a city: for this reason Rome has been often defined as capital of two states. Rome's history spans 28 centuries. While Roman mythology dates the founding of Rome at around 753 BC, the site has been inhabited for much longer, making it one of the oldest continuously occupied sites in Europe. The city's early population originated from a mix of Latins, Etruscans, and Sabines. Eventually, the city successively became the capital of the Roman Kingdom, the Roman Republic and the Roman Empire, and is regarded by some as the first ever metropolis. It was first called The Eternal City (Latin: Urbs Aeterna; Italian: La Città Eterna) by the Roman poet Tibullus in the 1st century BC, and the expression was also taken up by Ovid, Virgil, and Livy. Rome is also called the \"Caput Mundi\" (Capital of the World). After the fall of the Western Empire, which marked the beginning of the Middle Ages, Rome slowly fell under the political control of the Papacy, and in the 8th century it became the capital of the Papal States, which lasted until 1870. Beginning with the Renaissance, almost all the popes since Nicholas V (1447–1455) pursued over four hundred years a coherent architectural and urban programme aimed at making the city the artistic and cultural centre of the world. In this way, Rome became first one of the major centres of the Italian Renaissance, and then the birthplace of both the Baroque style and Neoclassicism. Famous artists, painters, sculptors and architects made Rome the centre of their activity, creating masterpieces throughout the city. In 1871, Rome became the capital of the Kingdom of Italy, which, in 1946, became the Italian Republic. Rome has the status of a global city. In 2016, Rome ranked as the 14th-most-visited city in the world, 3rd most visited in the European Union, and the most popular tourist attraction in Italy. Its historic centre is listed by UNESCO as a World Heritage Site. The famous Vatican Museums are among the world's most visited museums while the Colosseum was the most popular tourist attraction in world with 7.4 million visitors in 2018. Host city for the 1960 Summer Olympics, Rome is the seat of several specialized agencies of the United Nations, such as the Food and Agriculture Organization (FAO), the World Food Programme (WFP) and the International Fund for Agricultural Development (IFAD). The city also hosts the Secretariat of the Parliamentary Assembly of the Union for the Mediterranean (UfM) as well as the headquarters of many international business companies such as Eni, Enel, TIM, Leonardo S.p.A., and national and international banks such as Unicredit and BNL. Its business district, called EUR, is the base of many companies involved in the oil industry, the pharmaceutical industry, and financial services. Rome is also an important fashion and design centre thanks to renowned international brands centered in the city. Rome's Cinecittà Studios have been the set of many Academy Award–winning movies.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //London
        c = new City();
        c.name = "London";
        c.description = "London (/ˈlʌndən/ LUN-dən) is the capital and largest city of both England and the United Kingdom. Standing on the River Thames in the south-east of England, at the head of its 50-mile (80 km) estuary leading to the North Sea, London has been a major settlement for two millennia. Londinium was founded by the Romans. The City of London, London's ancient core − an area of just 1.12 square miles (2.9 km2) and colloquially known as the Square Mile − retains boundaries that follow closely its medieval limits. The City of Westminster is also an Inner London borough holding city status. Greater London is governed by the Mayor of London and the London Assembly. London is considered to be one of the world's most important global cities and has been termed the world's most powerful, most desirable, most influential, most visited, most expensive, innovative, sustainable, most investment friendly, most popular for work, and the most vegetarian friendly city in the world. London exerts a considerable impact upon the arts, commerce, education, entertainment, fashion, finance, healthcare, media, professional services, research and development, tourism and transportation. London ranks 26 out of 300 major cities for economic performance. It is one of the largest financial centres and has either the fifth or sixth largest metropolitan area GDP. It is the most-visited city as measured by international arrivals and has the busiest city airport system as measured by passenger traffic. It is the leading investment destination, hosting more international retailers and ultra high-net-worth individuals than any other city. London's universities form the largest concentration of higher education institutes in Europe. In 2012, London became the first city to have hosted three modern Summer Olympic Games. London has a diverse range of people and cultures, and more than 300 languages are spoken in the region. Its estimated mid-2016 municipal population (corresponding to Greater London) was 8,787,892, the most populous of any city in the European Union and accounting for 13.4% of the UK population. London's urban area is the second most populous in the EU, after Paris, with 9,787,426 inhabitants at the 2011 census. The population within the London commuter belt is the most populous in the EU with 14,040,163 inhabitants in 2016. London was the world's most populous city from c. 1831 to 1925. London contains four World Heritage Sites: the Tower of London; Kew Gardens; the site comprising the Palace of Westminster, Westminster Abbey, and St Margaret's Church; and the historic settlement in Greenwich where the Royal Observatory, Greenwich defines the Prime Meridian, 0° longitude, and Greenwich Mean Time. Other landmarks include Buckingham Palace, the London Eye, Piccadilly Circus, St Paul's Cathedral, Tower Bridge, Trafalgar Square and The Shard. London has numerous museums, galleries, libraries and sporting events. These include the British Museum, National Gallery, Natural History Museum, Tate Modern, British Library and West End theatres. The London Underground is the oldest underground railway network in the world.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Paris
        c = new City();
        c.name = "Paris";
        c.description = "Paris (French pronunciation: \u200B[paʁi]) is the capital and most populous city of France, with an area of 105 square kilometres (41 square miles) and an official estimated population of 2,140,526 residents as of 1 January 2019. Since the 17th century, Paris has been one of Europe's major centres of finance, diplomacy, commerce, fashion, science, and the arts. The City of Paris is the centre and seat of government of the Île-de-France, or Paris Region, which has an estimated official 2019 population of 12,213,364, or about 18 percent of the population of France. The Paris Region had a GDP of €681 billion (US$850 billion) in 2016, accounting for 31 percent of the GDP of France, and was the 5th largest region by GDP in the world. According to the Economist Intelligence Unit Worldwide Cost of Living Survey in 2018, Paris was the second most expensive city in the world, after Singapore, and ahead of Zurich, Hong Kong, Oslo and Geneva. Another source ranked Paris as most expensive, on a par with Singapore and Hong-Kong, in 2018. The city is a major rail, highway, and air-transport hub served by two international airports: Paris-Charles de Gaulle (the second busiest airport in Europe) and Paris-Orly. Opened in 1900, the city's subway system, the Paris Métro, serves 5.23 million passengers daily, and is the second busiest metro system in Europe after Moscow Metro. Gare du Nord is the 24th busiest railway station in the world, and the first located outside Japan, with 262 million passengers in 2015. Paris is especially known for its museums and architectural landmarks: the Louvre was the most visited art museum in the world in 2018, with 10.2 million visitors. The Musée d'Orsay and Musée de l'Orangerie are noted for their collections of French Impressionist art, and the Pompidou Centre Musée National d'art Moderne has the largest collection of modern and contemporary art in Europe. The historical district along the Seine in the city centre is classified as a UNESCO Heritage Site. Popular landmarks in the centre of the city include the Cathedral of Notre Dame de Paris and the Gothic royal chapel of Sainte-Chapelle, both on the Île de la Cité; the Eiffel Tower, constructed for the Paris Universal Exposition of 1889; the Grand Palais and Petit Palais, built for the Paris Universal Exposition of 1900; the Arc de Triomphe on the Champs-Élysées, and the Basilica of Sacré-Coeur on the hill of Montmartre. Paris received 23 million visitors in 2017, measured by hotel stays, with the largest numbers of foreign visitors coming from the United States, the UK, Germany and China. It was ranked as the third most visited travel destination in the world in 2017, after Bangkok and London. The football club Paris Saint-Germain and the rugby union club Stade Français are based in Paris. The 80,000-seat Stade de France, built for the 1998 FIFA World Cup, is located just north of Paris in the neighbouring commune of Saint-Denis. Paris hosts the annual French Open Grand Slam tennis tournament on the red clay of Roland Garros. Paris hosted the Olympic Games in 1900, 1924 and will host the 2024 Summer Olympics. The 1938 and 1998 FIFA World Cups, the 2007 Rugby World Cup, and the 1960, 1984, and 2016 UEFA European Championships were also held in the city and, every July, the Tour de France bicycle race finishes there.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Madrid
        c = new City();
        c.name = "Madrid";
        c.description = "Madrid (/məˈdrɪd/, Spanish: [maˈðɾið], locally [maˈðr(:)iθ]) is the capital of Spain and the largest municipality in both the Community of Madrid and Spain as a whole. The city has almost 3.3 million inhabitants and a metropolitan area population of approximately 6.5 million. It is the third-largest city in the European Union (EU), smaller than only London and Berlin, and its monocentric metropolitan area is the third-largest in the EU, smaller only than those of London and Paris. The municipality covers 604.3 km2 (233.3 sq mi). Madrid lies on the River Manzanares in the centre of both the country and the Community of Madrid (which comprises the city of Madrid, its conurbation and extended suburbs and villages); this community is bordered by the autonomous communities of Castile and León and Castile-La Mancha. As the capital city of Spain, seat of government, and residence of the Spanish monarch, Madrid is also the political, economic and cultural centre of the country. The current mayor is Manuela Carmena from the party Ahora Madrid. The Madrid urban agglomeration has the third-largest GDP in the European Union and its influence in politics, education, entertainment, environment, media, fashion, science, culture, and the arts all contribute to its status as one of the world's major global cities. Madrid is home to two world-famous football clubs, Real Madrid and Atlético Madrid. Due to its economic output, high standard of living, and market size, Madrid is considered the leading economic hub of the Iberian Peninsula and of Southern Europe. It hosts the head offices of the vast majority of major Spanish companies, such as Telefónica, IAG or Repsol. Madrid is also the 10th most liveable city in the world according to Monocle magazine, in its 2017 index. Madrid houses the headquarters of the World Tourism Organization (UNWTO), belonging to the United Nations Organization (UN), the Ibero-American General Secretariat (SEGIB), the Organization of Ibero-American States (OEI), and the Public Interest Oversight Board (PIOB). It also hosts major international regulators and promoters of the Spanish language: the Standing Committee of the Association of Spanish Language Academies, headquarters of the Royal Spanish Academy (RAE), the Cervantes Institute and the Foundation of Urgent Spanish (Fundéu BBVA). Madrid organises fairs such as FITUR, ARCO, SIMO TCI and the Madrid Fashion Week. While Madrid possesses modern infrastructure, it has preserved the look and feel of many of its historic neighbourhoods and streets. Its landmarks include the Royal Palace of Madrid; the Royal Theatre with its restored 1850 Opera House; the Buen Retiro Park, founded in 1631; the 19th-century National Library building (founded in 1712) containing some of Spain's historical archives; a large number of national museums, and the Golden Triangle of art, located along the Paseo del Prado and comprising three art museums: Prado Museum, the Reina Sofía Museum, a museum of modern art, and the Thyssen-Bornemisza Museum, which complements the holdings of the other two museums. Cibeles Palace and Fountain have become one of the monument symbols of the city.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Berlin
        c = new City();
        c.name = "Berlin";
        c.description = "Berlin (/bɜːrˈlɪn/; German pronunciation: [bɛɐ̯ˈliːn]) is the capital and largest city of Germany by both area and population. Its 3,748,148 (2018) inhabitants make it the second most populous city proper of the European Union after London. The city is one of Germany's 16 federal states. It is surrounded by the state of Brandenburg, and contiguous with its capital, Potsdam. The two cities are at the center of the Berlin-Brandenburg capital region, which is, with about six million inhabitants and an area of more than 30,000 km², Germany's third-largest metropolitan region after the Rhine-Ruhr and Rhine-Main regions. Berlin straddles the banks of the River Spree, which flows into the River Havel (a tributary of the River Elbe) in the western borough of Spandau. Among the city's main topographical features are the many lakes in the western and southeastern boroughs formed by the Spree, Havel, and Dahme rivers (the largest of which is Lake Müggelsee). Due to its location in the European Plain, Berlin is influenced by a temperate seasonal climate. About one-third of the city's area is composed of forests, parks, gardens, rivers, canals and lakes. The city lies in the Central German dialect area, the Berlin dialect being a variant of the Lusatian-New Marchian dialects. First documented in the 13th century and situated at the crossing of two important historic trade routes, Berlin became the capital of the Margraviate of Brandenburg (1417–1701), the Kingdom of Prussia (1701–1918), the German Empire (1871–1918), the Weimar Republic (1919–1933), and the Third Reich (1933–1945). Berlin in the 1920s was the third largest municipality in the world. After World War II and its subsequent occupation by the victorious countries, the city was divided; West Berlin became a de facto West German exclave, surrounded by the Berlin Wall (1961–1989) and East German territory. East Berlin was declared capital of East Germany, while Bonn became the West German capital. Following German reunification in 1990, Berlin once again became the capital of all of Germany. Berlin is a world city of culture, politics, media and science. Its economy is based on high-tech firms and the service sector, encompassing a diverse range of creative industries, research facilities, media corporations and convention venues. Berlin serves as a continental hub for air and rail traffic and has a highly complex public transportation network. The metropolis is a popular tourist destination. Significant industries also include IT, pharmaceuticals, biomedical engineering, clean tech, biotechnology, construction and electronics. Berlin is home to world-renowned universities, orchestras, museums, and entertainment venues, and is host to many sporting events. Its Zoological Garden is the most visited zoo in Europe and one of the most popular worldwide. With the world's oldest large-scale movie studio complex, Berlin is an increasingly popular location for international film productions. The city is well known for its festivals, diverse architecture, nightlife, contemporary arts and a very high quality of living. Since the 2000s Berlin has seen the emergence of a cosmopolitan entrepreneurial scene.";
        c.kinds.add(kindManager.getKind(2));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 0;
        cityBox.put(c);

        //Barcelona
        c = new City();
        c.name = "Barcelona";
        c.description = "Barcelona (/ˌbɑːrsəˈloʊnə/ BAR-sə-LOH-nə, Catalan: [bəɾsəˈlonə], Spanish: [baɾθeˈlona]) is a city in Spain. It is the capital and largest city of the autonomous community of Catalonia, as well as the second most populous municipality of Spain. With a population of 1.6 million within city limits, its urban area extends to numerous neighbouring municipalities within the Province of Barcelona and is home to around 4.8 million people, making it the sixth most populous urban area in the European Union after Paris, London, Madrid, the Ruhr area and Milan. It is one of the largest metropolises on the Mediterranean Sea, located on the coast between the mouths of the rivers Llobregat and Besòs, and bounded to the west by the Serra de Collserola mountain range, the tallest peak of which is 512 metres (1,680 feet) high. Founded as a Roman city, in the Middle Ages Barcelona became the capital of the County of Barcelona. After merging with the Kingdom of Aragon, Barcelona continued to be an important city in the Crown of Aragon as an economic and administrative centre of this Crown and the capital of the Principality of Catalonia. Barcelona has a rich cultural heritage and is today an important cultural centre and a major tourist destination. Particularly renowned are the architectural works of Antoni Gaudí and Lluís Domènech i Montaner, which have been designated UNESCO World Heritage Sites. The headquarters of the Union for the Mediterranean are located in Barcelona. The city is known for hosting the 1992 Summer Olympics as well as world-class conferences and expositions and also many international sport tournaments. Barcelona is one of the world's leading tourist, economic, trade fair and cultural centres, and its influence in commerce, education, entertainment, media, fashion, science, and the arts all contribute to its status as one of the world's major global cities. It is a major cultural and economic centre in southwestern Europe, 24th in the world (before Zürich, after Frankfurt) and a financial centre. In 2008 it was the fourth most economically powerful city by GDP in the European Union and 35th in the world with GDP amounting to €177 billion. In 2012 Barcelona had a GDP of $170 billion; and it was leading Spain in employment rate in that moment. In 2009 the city was ranked Europe's third and one of the world's most successful as a city brand. In the same year the city was ranked Europe's fourth best city for business and fastest improving European city, with growth improved by 17% per year, and the city has been experiencing strong and renewed growth for the past three years. Since 2011 Barcelona has been a leading smart city in Europe. Barcelona is a transport hub, with the Port of Barcelona being one of Europe's principal seaports and busiest European passenger port, an international airport, Barcelona–El Prat Airport, which handles over 50 million passengers per year, an extensive motorway network, and a high-speed rail line with a link to France and the rest of Europe.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Vienna
        c = new City();
        c.name = "Vienna";
        c.description = "Vienna (/viˈɛnə/; German: Wien [viːn]) is the federal capital and largest city of Austria, and one of the nine states of Austria. Vienna is Austria's primate city, with a population of about 1.9 million (2.6 million within the metropolitan area, nearly one third of Austria's population), and its cultural, economic, and political centre. It is the 7th-largest city by population within city limits in the European Union. Until the beginning of the 20th century, it was the largest German-speaking city in the world, and before the splitting of the Austro-Hungarian Empire in World War I, the city had 2 million inhabitants. Today, it has the second largest number of German speakers after Berlin. Vienna is host to many major international organizations, including the United Nations and OPEC. The city is located in the eastern part of Austria and is close to the borders of the Czech Republic, Slovakia, and Hungary. These regions work together in a European Centrope border region. Along with nearby Bratislava, Vienna forms a metropolitan region with 3 million inhabitants. In 2001, the city centre was designated a UNESCO World Heritage Site. In July 2017 it was moved to the list of World Heritage in Danger. Apart from being regarded as the City of Music because of its musical legacy, Vienna is also said to be \"The City of Dreams\" because it was home to the world's first psychoanalyst – Sigmund Freud. The city's roots lie in early Celtic and Roman settlements that transformed into a Medieval and Baroque city, and then the capital of the Austro-Hungarian Empire. It is well known for having played an essential role as a leading European music centre, from the great age of Viennese Classicism through the early part of the 20th century. The historic centre of Vienna is rich in architectural ensembles, including Baroque castles and gardens, and the late-19th-century Ringstraße lined with grand buildings, monuments and parks. Vienna is known for its high quality of life. In a 2005 study of 127 world cities, the Economist Intelligence Unit ranked the city first (in a tie with Vancouver and San Francisco) for the world's most liveable cities. Between 2011 and 2015, Vienna was ranked second, behind Melbourne. In 2018, it replaced Melbourne as the number one spot. For ten consecutive years (2009–2019), the human-resource-consulting firm Mercer ranked Vienna first in its annual \"Quality of Living\" survey of hundreds of cities around the world. Monocle's 2015 \"Quality of Life Survey\" ranked Vienna second on a list of the top 25 cities in the world \"to make a base within.\" The UN-Habitat classified Vienna as the most prosperous city in the world in 2012/2013. The city was ranked 1st globally for its culture of innovation in 2007 and 2008, and sixth globally (out of 256 cities) in the 2014 Innovation Cities Index, which analyzed 162 indicators in covering three areas: culture, infrastructure, and markets. Vienna regularly hosts urban planning conferences and is often used as a case study by urban planners. Between 2005 and 2010, Vienna was the world's number-one destination for international congresses and conventions. It attracts over 6.8 million tourists a year.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //New York
        c = new City();
        c.name = "New York";
        c.description = "The City of New York, usually called either New York City (NYC) or simply New York (NY), is the most populous city in the United States. With an estimated 2017 population of 8,622,698 distributed over a land area of about 302.6 square miles (784 km2), New York is also the most densely populated major city in the United States. Located at the southern tip of the state of New York, the city is the center of the New York metropolitan area, the largest metropolitan area in the world by urban landmass and one of the world's most populous megacities, with an estimated 20,320,876 people in its 2017 Metropolitan Statistical Area and 23,876,155 residents in its Combined Statistical Area. A global power city, New York City has been described as the cultural, financial, and media capital of the world, and exerts a significant impact upon commerce, entertainment, research, technology, education, politics, tourism, art, fashion, and sports. The city's fast pace has inspired the term New York minute. Home to the headquarters of the United Nations, New York is an important center for international diplomacy. Situated on one of the world's largest natural harbors, New York City consists of five boroughs, each of which is a separate county of the State of New York. The five boroughs – Brooklyn, Queens, Manhattan, The Bronx, and Staten Island – were consolidated into a single city in 1898. The city and its metropolitan area constitute the premier gateway for legal immigration to the United States. As many as 800 languages are spoken in New York, making it the most linguistically diverse city in the world. New York City is home to more than 3.2 million residents born outside the United States, the largest foreign-born population of any city in the world. In 2017, the New York metropolitan area produced a gross metropolitan product (GMP) of US$1.73 trillion. If greater New York City were a sovereign state, it would have the 12th highest GDP in the world. New York is home to the highest number of billionaires of any city in the world. New York City traces its origins to a trading post founded by colonists from the Dutch Republic in 1624 on Lower Manhattan; the post was named New Amsterdam in 1626. The city and its surroundings came under English control in 1664 and were renamed New York after King Charles II of England granted the lands to his brother, the Duke of York. New York served as the capital of the United States from 1785 until 1790. It has been the country's largest city since 1790. The Statue of Liberty greeted millions of immigrants as they came to the U.S. by ship in the late 19th and early 20th centuries and is an international symbol of the U.S. and its ideals of liberty and peace. In the 21st century, New York has emerged as a global node of creativity and entrepreneurship, social tolerance, and environmental sustainability, and as a symbol of freedom and cultural diversity. Many districts and landmarks in New York City are well known, with the city having three of the world's ten most visited tourist attractions in 2013 and receiving a record 62.8 million tourists in 2017. Several sources have ranked New York the most photographed city in the world. Times Square, iconic as the world's \"heart\" and its \"Crossroads\", is the brightly illuminated hub of the Broadway Theater District, one of the world's busiest pedestrian intersections, and a major center of the world's entertainment industry. The names of many of the city's landmarks, skyscrapers, and parks are known around the world. Manhattan's real estate market is among the most expensive in the world. New York is home to the largest ethnic Chinese population outside of Asia, with multiple signature Chinatowns developing across the city. Providing continuous 24/7 service, the New York City Subway is the largest single-operator rapid transit system worldwide, with 472 rail stations. Over 120 colleges and universities are located in New York City, including Columbia University, New York University, and Rockefeller University, which have been ranked among the top universities in the world. Anchored by Wall Street in the Financial District of Lower Manhattan, New York has been called both the most economically powerful city and the leading financial center of the world, and the city is home to the world's two largest stock exchanges by total market capitalization, the New York Stock Exchange and NASDAQ.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Hong Kong
        c = new City();
        c.name = "Hong Kong";
        c.description = "Hong Kong (/ˌhɒŋˈkɒŋ/; Hong Kong Cantonese: [hœ́ːŋ.kɔ̌ːŋ]), officially the Hong Kong Special Administrative Region of the People's Republic of China and commonly abbreviated as HK, is a special administrative region on the eastern side of the Pearl River estuary in southern China. With over 7.4 million people of various nationalities in a 1,104-square-kilometre (426 sq mi) territory, Hong Kong is the world's fourth most densely populated region. Hong Kong became a colony of the British Empire after Qing Empire ceded Hong Kong Island at the end of the First Opium War in 1842. The colony expanded to the Kowloon Peninsula in 1860 after the Second Opium War, and was further extended when Britain obtained a 99-year lease of the New Territories in 1898. The entire territory was transferred to China in 1997. As a special administrative region, Hong Kong's system of government is separate from that of mainland China and its people identify more as Hongkongers rather than Chinese. Originally a sparsely populated area of farming and fishing villages, the territory has become one of the world's most significant financial centres and commercial ports. It is the world's seventh-largest trading entity, and its legal tender (the Hong Kong dollar) is the world's 13th-most traded currency. Although the city has one of the highest per capita incomes in the world, it has severe income inequality. The territory has the largest number of skyscrapers in the world, most surrounding Victoria Harbour. Hong Kong ranks seventh on the UN Human Development Index, and has the sixth-longest life expectancy in the world. Although over 90 per cent of its population uses public transportation, air pollution from neighbouring industrial areas of mainland China has resulted in a high level of atmospheric particulates.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Bangkok
        c = new City();
        c.name = "Bangkok";
        c.description = "Bangkok is the capital and most populous city of Thailand. It is known in Thai as Krung Thep Maha Nakhon or simply Krung Thep. The city occupies 1,568.7 square kilometres (605.7 sq mi) in the Chao Phraya River delta in central Thailand, and has a population of over eight million, or 12.6 percent of the country's population. Over fourteen million people (22.2 percent) lived within the surrounding Bangkok Metropolitan Region at the 2010 census, making Bangkok the nation's primate city, significantly dwarfing Thailand's other urban centres in terms of importance. Bangkok traces its roots to a small trading post during the Ayutthaya Kingdom in the 15th century, which eventually grew and became the site of two capital cities: Thonburi in 1768 and Rattanakosin in 1782. Bangkok was at the heart of the modernization of Siam, later renamed Thailand, during the late-19th century, as the country faced pressures from the West. The city was at the centre of Thailand's political struggles throughout the 20th century, as the country abolished absolute monarchy, adopted constitutional rule, and underwent numerous coups and several uprisings. The city grew rapidly during the 1960s through the 1980s and now exerts a significant impact on Thailand's politics, economy, education, media and modern society. The Asian investment boom in the 1980s and 1990s led many multinational corporations to locate their regional headquarters in Bangkok. The city is now a regional force in finance and business. It is an international hub for transport and health care, and has emerged as a centre for the arts, fashion, and entertainment. The city is known for its street life and cultural landmarks, as well as its red-light districts. The Grand Palace and Buddhist temples including Wat Arun and Wat Pho stand in contrast with other tourist attractions such as the nightlife scenes of Khaosan Road and Patpong. Bangkok is among the world's top tourist destinations, and has been named the world's most visited city in several rankings. Bangkok's rapid growth coupled with little urban planning has resulted in a haphazard cityscape and inadequate infrastructure. An inadequate road network, despite an extensive expressway network, together with substantial private car usage, have led to chronic and crippling traffic congestion, which caused severe air pollution in the 1990s. The city has since turned to public transport in an attempt to solve the problem. Five rapid transit lines are now in operation, with more systems under construction or planned by the national government and the Bangkok Metropolitan Administration.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Rio de Janeiro
        c = new City();
        c.name = "Rio de Janeiro";
        c.description = "Rio de Janeiro (/ˈriːoʊ di ʒəˈnɛəroʊ, - deɪ -, - də -/; Portuguese: [ˈʁi.u d(ʒi) ʒɐˈne(j)ɾu]; River of January), or simply Rio, is anchor to the Rio de Janeiro metropolitan area and the second-most populous municipality in Brazil and the sixth-most populous in the Americas. Rio de Janeiro is the capital of the state of Rio de Janeiro, Brazil's third-most populous state. Part of the city has been designated as a World Heritage Site, named \"Rio de Janeiro: Carioca Landscapes between the mountain and the Sea\", by UNESCO on 1 July 2012 as a Cultural Landscape. Founded in 1565 by the Portuguese, the city was initially the seat of the Captaincy of Rio de Janeiro, a domain of the Portuguese Empire. Later, in 1763, it became the capital of the State of Brazil, a state of the Portuguese Empire. In 1808, when the Portuguese Royal Court transferred itself from Portugal to Brazil, Rio de Janeiro became the chosen seat of the court of Queen Maria I of Portugal, who subsequently, in 1815, under the leadership of her son, the Prince Regent, and future King João VI of Portugal, raised Brazil to the dignity of a kingdom, within the United Kingdom of Portugal, Brazil, and Algarves. Rio stayed the capital of the pluricontinental Lusitanian monarchy until 1822, when the War of Brazilian Independence began. This is one of the few instances in history that the capital of a colonising country officially shifted to a city in one of its colonies. Rio de Janeiro subsequently served as the capital of the independent monarchy, the Empire of Brazil, until 1889, and then the capital of a republican Brazil until 1960 when the capital was transferred to Brasília. Rio de Janeiro has the second largest municipal GDP in the country, and 30th largest in the world in 2008, estimated at about R$343 billion (IBGE, 2008) (nearly US$201 billion). It is headquarters to Brazilian oil, mining, and telecommunications companies, including two of the country's major corporations – Petrobras and Vale – and Latin America's largest telemedia conglomerate, Grupo Globo. The home of many universities and institutes, it is the second-largest center of research and development in Brazil, accounting for 17% of national scientific output according to 2005 data. Despite the high perception of crime, the city has a lower incidence of crime than Northeast Brazil, but it is far more criminalized than the south region of Brazil, which is considered the safest in the country. Rio de Janeiro is one of the most visited cities in the Southern Hemisphere and is known for its natural settings, Carnival, samba, bossa nova, and balneario beaches such as Barra da Tijuca, Copacabana, Ipanema, and Leblon. In addition to the beaches, some of the most famous landmarks include the giant statue of Christ the Redeemer atop Corcovado mountain, named one of the New Seven Wonders of the World; Sugarloaf mountain with its cable car; the Sambódromo (Sambadrome), a permanent grandstand-lined parade avenue which is used during Carnival; and Maracanã Stadium, one of the world's largest football stadiums. Rio de Janeiro was the host of the 2016 Summer Olympics and the 2016 Summer Paralympics, making the city the first South American and Portuguese-speaking city to ever host the events, and the third time the Olympics were held in a Southern Hemisphere city. The Maracanã Stadium held the finals of the 1950 and 2014 FIFA World Cups, the 2013 FIFA Confederations Cup, and the XV Pan American Games.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Venice
        c = new City();
        c.name = "Venice";
        c.description = "Venice (/ˈvɛnɪs/, VEN-iss; Italian: Venezia [veˈnɛttsja]; Venetian: Venesia, Venexia [veˈnɛsja]) is a city in northeastern Italy and the capital of the Veneto region. It is situated on a group of 118 small islands that are separated by canals and linked by over 400 bridges. The islands are located in the shallow Venetian Lagoon, an enclosed bay that lies between the mouths of the Po and the Piave rivers (more exactly between the Brenta and the Sile). In 2018, 260,897 people resided in the Comune di Venezia, of whom around 55,000 live in the historical city of Venice (Centro storico). Together with Padua and Treviso, the city is included in the Padua-Treviso-Venice Metropolitan Area (PATREVE), which is considered a statistical metropolitan area, with a total population of 2.6 million. The name is derived from the ancient Veneti people who inhabited the region by the 10th century BC. The city was historically the capital of the Republic of Venice. The 697–1797 Republic of Venice was a major financial and maritime power during the Middle Ages and Renaissance, and a staging area for the Crusades and the Battle of Lepanto, as well as an important center of commerce (especially silk, grain, and spice) and art in the 13th century up to the end of the 17th century. The city-state of Venice is considered to have been the first real international financial center, emerging in the 9th century and reaching its greatest prominence in the 14th century. This made Venice a wealthy city throughout most of its history. After the Napoleonic Wars and the Congress of Vienna, the Republic was annexed by the Austrian Empire, until it became part of the Kingdom of Italy in 1866, following a referendum held as a result of the Third Italian War of Independence. Venice has been known as \"La Dominante\", \"La Serenissima\", \"Queen of the Adriatic\", \"City of Water\", \"City of Masks\", \"City of Bridges\", \"The Floating City\", and \"City of Canals\". The lagoon and a part of the city are listed as a UNESCO World Heritage Site. Parts of Venice are renowned for the beauty of their settings, their architecture, and artwork. Venice is known for several important artistic movements—especially during the Renaissance period—has played an important role in the history of symphonic and operatic music, and is the birthplace of Antonio Vivaldi. Although the city is facing some major challenges (including financial difficulties, pollution, an excessive number of tourists and problems caused by cruise ships sailing close to the buildings), Venice remains a very popular tourist destination, an iconic Italian city, and has been ranked the most beautiful city in the world.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Prague
        c = new City();
        c.name = "Prague";
        c.description = "Prague (/prɑːɡ/; Czech: Praha [ˈpraɦa]) is the capital and largest city in the Czech Republic, the 14th largest city in the European Union and the historical capital of Bohemia. Situated in the north-west of the country on the Vltava river, the city is home to about 1.3 million people, while its metropolitan area is estimated to have a population of 2.6 million. The city has a temperate climate, with warm summers and chilly winters. Prague has been a political, cultural and economic centre of central Europe complete with a rich history. Founded during the Romanesque and flourishing by the Gothic, Renaissance and Baroque eras, Prague was the capital of the Kingdom of Bohemia and the main residence of several Holy Roman Emperors, most notably of Charles IV (r. 1346–1378). It was an important city to the Habsburg Monarchy and its Austro-Hungarian Empire. The city played major roles in the Bohemian and Protestant Reformation, the Thirty Years' War and in 20th-century history as the capital of Czechoslovakia, during both World Wars and the post-war Communist era. Prague is home to a number of well-known cultural attractions, many of which survived the violence and destruction of 20th-century Europe. Main attractions include Prague Castle, Charles Bridge, Old Town Square with the Prague astronomical clock, the Jewish Quarter, Petřín hill and Vyšehrad. Since 1992, the extensive historic centre of Prague has been included in the UNESCO list of World Heritage Sites. The city has more than ten major museums, along with numerous theatres, galleries, cinemas and other historical exhibits. An extensive modern public transportation system connects the city. Also, it is home to a wide range of public and private schools, including Charles University in Prague, the oldest university in Central Europe. Prague is classified as an \"Alpha −\" global city according to GaWC studies and ranked sixth in the Tripadvisor world list of best destinations in 2016. Its rich history makes it a popular tourist destination and as of 2017, the city receives more than 8.5 million international visitors annually. Prague is the fourth most visited European city after London, Paris and Rome.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 0;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Siena
        c = new City();
        c.name = "Siena";
        c.description = "Siena (Italian pronunciation: [ˈsjɛːna]; in English sometimes spelled Sienna; Latin: Sena Iulia) is a city in Tuscany, Italy. It is the capital of the province of Siena. The historic centre of Siena has been declared by UNESCO a World Heritage Site. It is one of the nation's most visited tourist attractions, with over 163,000 international arrivals in 2008. Siena is famous for its cuisine, art, museums, medieval cityscape and the Palio, a horse race held twice a year. Siena is located in the central part of Tuscany, in the middle of a vast hilly landscape between the Arbia river valley (south), the Merse valley (south-west), the Elsa valley (north), the Chianti hills (north-east), the Montagnola Senese (west) and the Crete Senesi (south-east). The city lies at 322 m above sea level. Siena has a typical inland Mediterranean climate. Average rainfall is 750 mm (29.5 in), with the maximum in November and the minimum in July. July is the hottest month, with an average temperature of 22.2 °C (72.0 °F), and January the coldest.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 0;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Tokyo
        c = new City();
        c.name = "Tokyo";
        c.description = "Tokyo (Tōkyō, English: /ˈtoʊkioʊ/, Japanese: [toːkʲoː]; lit. \"Eastern Capital\"), officially Tokyo Metropolis (Tōkyō-to), one of the 47 prefectures of Japan, has served as the Japanese capital since 1869. As of 2018, the Greater Tokyo Area ranked as the most populous metropolitan area in the world. The urban area houses the seat of the Emperor of Japan, of the Japanese government and of the National Diet. Tokyo forms part of the Kantō region on the southeastern side of Japan's main island, Honshu, and includes the Izu Islands and Ogasawara Islands. Tokyo was formerly named Edo when Shōgun Tokugawa Ieyasu made the city his headquarters in 1603. It became the capital after Emperor Meiji moved his seat to the city from Kyoto in 1868; at that time Edo was renamed Tokyo. Tokyo Metropolis formed in 1943 from the merger of the former Tokyo Prefecture (Tōkyō-fu) and the city of Tokyo (Tōkyō-shi). Tokyo is often referred to as a city but is officially known and governed as a \"metropolitan prefecture\", which differs from and combines elements of a city and a prefecture, a characteristic unique to Tokyo. The 23 Special Wards of Tokyo were formerly Tokyo City. On July 1, 1943, it merged with Tokyo Prefecture and became Tokyo Metropolis with an additional 26 municipalities in the western part of the prefecture, and the Izu islands and Ogasawara islands south of Tokyo. The population of the special wards is over 9 million people, with the total population of Tokyo Metropolis exceeding 13.8 million. The prefecture is part of the world's most populous metropolitan area called the Greater Tokyo Area with over 38 million people and the world's largest urban agglomeration economy. As of 2011, Tokyo hosted 51 of the Fortune Global 500 companies, the highest number of any city in the world at that time. Tokyo ranked third (twice) in the International Financial Centres Development Index. The city is home to various television networks such as Fuji TV, Tokyo MX, TV Tokyo, TV Asahi, Nippon Television, NHK and the Tokyo Broadcasting System. Tokyo ranks first in the Global Economic Power Index and third in the Global Cities Index. The GaWC's 2018 inventory classified Tokyo as an alpha+ world city  – and as of 2014 TripAdvisor's World City Survey ranked Tokyo first in its \"Best overall experience\" category (the city also ranked first in the following categories: \"helpfulness of locals\", \"nightlife\", \"shopping\", \"local public transportation\" and \"cleanliness of streets\"). As of 2018 Tokyo ranked as the 2nd-most expensive city for expatriates, according to the Mercer consulting firm. and also the world's 11th-most expensive city according to the Economist Intelligence Unit's cost-of-living survey. In 2015, Tokyo was named the Most Liveable City in the world by the magazine Monocle. The Michelin Guide has awarded Tokyo by far the most Michelin stars of any city in the world. Tokyo was ranked first out of all sixty cities in the 2017 Safe Cities Index. The QS Best Student Cities ranked Tokyo as the 3rd-best city in the world to be a university student in 2016 and 2nd in 2018. Tokyo hosted the 1964 Summer Olympics, the 1979 G-7 summit, the 1986 G-7 summit, and the 1993 G-7 summit, and will host the 2019 Rugby World Cup, the 2020 Summer Olympics and the 2020 Summer Paralympics.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Beijing
        c = new City();
        c.name = "Beijing";
        c.description = "Beijing (/beɪˈdʒɪŋ/, nonstandard /beɪˈʒɪŋ/;  Mandarin pronunciation: [pèi.tɕíŋ]), formerly romanized as Peking, is the capital of the People's Republic of China, the world's third most populous city proper, and most populous capital city. The city, located in northern China, is governed as a municipality under the direct administration of central government with 16 urban, suburban, and rural districts. Beijing Municipality is surrounded by Hebei Province with the exception of neighboring Tianjin Municipality to the southeast; together the three divisions form the Jingjinji metropolitan region and the national capital region of China. Beijing is an important world capital and global power city, and one of the world's leading centers for politics, economy and business, finance, education, culture, innovation and technology, architecture, language, and diplomacy. A megacity, Beijing is the second largest Chinese city by urban population after Shanghai and is the nation's political, cultural, and educational center. It is home to the headquarters of most of China's largest state-owned companies and houses the largest number of Fortune Global 500 companies in the world, as well as the world's four biggest financial institutions. It is also a major hub for the national highway, expressway, railway, and high-speed rail networks. The Beijing Capital International Airport has been the second busiest in the world by passenger traffic since 2010, and, as of 2016, the city's subway network is the busiest and second longest in the world. Combining both modern and traditional architecture, Beijing is one of the oldest cities in the world, with a rich history dating back three millennia. As the last of the Four Great Ancient Capitals of China, Beijing has been the political center of the country for most of the past eight centuries, and was the largest city in the world by population for much of the second millennium A.D. Encyclopædia Britannica notes that \"few cities in the world have served for so long as the political headquarters and cultural center of an area as immense as China.\" With mountains surrounding the inland city on three sides, in addition to the old inner and outer city walls, Beijing was strategically poised and developed to be the residence of the emperor and thus was the perfect location for the imperial capital. The city is renowned for its opulent palaces, temples, parks, gardens, tombs, walls and gates. It has seven UNESCO World Heritage Sites—the Forbidden City, Temple of Heaven, Summer Palace, Ming Tombs, Zhoukoudian, and parts of the Great Wall and the Grand Canal— all tourist locations. Siheyuans, the city's traditional housing style, and hutongs, the narrow alleys between siheyuans, are major tourist attractions and are common in urban Beijing. Many of Beijing's 91 universities consistently rank among the best in China, such as the Peking University and Tsinghua University. Beijing CBD is a center for Beijing's economic expansion, with the ongoing or recently completed construction of multiple skyscrapers. Beijing's Zhongguancun area is known as China's Silicon Valley and a center of innovation and technology entrepreneurship.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Florence
        c = new City();
        c.name = "Florence";
        c.description = "Florence (/ˈflɒrəns/ FLORR-ənss; Italian: Firenze, [fiˈrɛntse]; Tuscan: Fiorenza) is the capital city of the Italian region of Tuscany. It is the most populous city in Tuscany, with 383,084 inhabitants in 2013, and over 1,520,000 in its metropolitan area. Florence was a centre of medieval European trade and finance and one of the wealthiest cities of that era. It is considered the birthplace of the Renaissance, and has been called \"the Athens of the Middle Ages\". A turbulent political history includes periods of rule by the powerful Medici family and numerous religious and republican revolutions. From 1865 to 1871 the city was the capital of the recently established Kingdom of Italy. The Florentine dialect forms the base of Standard Italian and it became the language of culture throughout Italy due to the prestige of the masterpieces by Dante Alighieri, Petrarch, Giovanni Boccaccio, Niccolò Machiavelli and Francesco Guicciardini. The city attracts millions of tourists each year, and the Historic Centre of Florence was declared a World Heritage Site by UNESCO in 1982. The city is noted for its culture, Renaissance art and architecture and monuments. The city also contains numerous museums and art galleries, such as the Uffizi Gallery and the Palazzo Pitti, and still exerts an influence in the fields of art, culture and politics. Due to Florence's artistic and architectural heritage, it has been ranked by Forbes as one of the most beautiful cities in the world. Florence is an important city in Italian fashion, being ranked in the top 15 fashion capitals of the world; furthermore, it is a major national economic centre, as well as a tourist and industrial hub. In 2008, the city had the 17th highest average income in Italy.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Milan
        c = new City();
        c.name = "Milan";
        c.description = "Milan (/mɪˈlæn/, also US: /mɪˈlɑːn/, Milanese: [miˈlãː]; Italian: Milano [miˈlaːno]) is a city in northern Italy, capital of Lombardy, and the second-most populous city in Italy after Rome, with the city proper having a population of 1,372,810 while its metropolitan city has a population of 3,245,308. Its continuously built-up urban area (that stretches beyond the boundaries of the Metropolitan City of Milan) has a population estimated to be about 5,270,000 over 1,891 square kilometres (730 square miles). The wider Milan metropolitan area, known as Greater Milan, is a polycentric metropolitan region that extends over central Lombardy and eastern Piedmont and which counts an estimated total population of 7.5 million, making it by far the largest metropolitan area in Italy and the 54th largest in the world. Milan served as capital of the Western Roman Empire from 286 to 402 and the Duchy of Milan during the medieval period and early modern age. Milan is considered a leading alpha global city, with strengths in the field of the art, commerce, design, education, entertainment, fashion, finance, healthcare, media, services, research and tourism. Its business district hosts Italy's stock exchange and the headquarters of national and international banks and companies. In terms of GDP, it has the third-largest economy among European cities after Paris and London, but the fastest in growth among the three, and is the wealthiest among European non-capital cities. Milan is considered part of the Blue Banana and one of the \"Four Motors for Europe\".The city has been recognized as one of the world's four fashion capitals thanks to several international events and fairs, including Milan Fashion Week and the Milan Furniture Fair, which are currently among the world's biggest in terms of revenue, visitors and growth. It hosted the Universal Exposition in 1906 and 2015. The city hosts numerous cultural institutions, academies and universities, with 11% of the national total enrolled students. Milan is the destination of 8 million overseas visitors every year, attracted by its museums and art galleries that boast some of the most important collections in the world, including major works by Leonardo da Vinci. The city is served by a large number of luxury hotels and is the fifth-most starred in the world by Michelin Guide. The city is home to two of Europe's most successful football teams, A.C. Milan and F.C. Internazionale, and one of Italy's main basketball teams, Olimpia Milano.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Naples
        c = new City();
        c.name = "Naples";
        c.description = "Naples (/ˈneɪpəlz/; Italian: Napoli [ˈnaːpoli]; Neapolitan: Napule [ˈnɑːpələ] or [ˈnɑːpulə]; Latin: Neapolis; Ancient Greek: Νεάπολις, lit. 'new city') is the regional capital of Campania and the third-largest municipality in Italy after Rome and Milan. In 2017, around 967,069 people lived within the city's administrative limits while its province-level municipality has a population of 3,115,320 residents. Its continuously built-up metropolitan area (that stretches beyond the boundaries of the Metropolitan City of Naples) is the second or third largest metropolitan area in Italy and one of the most densely populated cities in Europe. First settled by Greeks in the second millennium BC, Naples is one of the oldest continuously inhabited urban areas in the world. In the ninth century BC, a colony known as Parthenope or Παρθενόπη was established on the Island of Megaride, later refounded as Neápolis in the sixth century BC. The city was an important part of Magna Graecia, played a major role in the merging of Greek and Roman society and a significant cultural centre under the Romans. It served as the capital of the Duchy of Naples (661–1139), then of the Kingdom of Naples (1282–1816) and finally of the Two Sicilies until the unification of Italy in 1861. Between 1925 and 1936, Naples was expanded and upgraded by Benito Mussolini's government but subsequently sustained severe damage from Allied bombing during World War II, which led to extensive post-1945 reconstruction work. Naples has experienced significant economic growth in recent decades, helped by the construction of the Centro Direzionale business district and an advanced transportation network, which includes the Alta Velocità high-speed rail link to Rome and Salerno and an expanded subway network. Naples is the third-largest urban economy in Italy, after Milan and Rome. The Port of Naples is one of the most important in Europe and home of the Allied Joint Force Command Naples, the NATO body that oversees North Africa, the Sahel and Middle East. Naples' historic city centre is the largest in Europe and a UNESCO World Heritage Site, with a wide range of culturally and historically significant sites nearby, including the Palace of Caserta and the Roman ruins of Pompeii and Herculaneum. Naples is also known for its natural beauties such as Posillipo, Phlegraean Fields, Nisida, and Vesuvius. Neapolitan cuisine is synonymous with pizza – which originated in the city – but it also includes many lesser-known dishes; Naples has the greatest number of accredited stars from the Michelin Guide of any Italian city. The best-known sports team in Naples is the Serie A club S.S.C. Napoli, two-time Italian champions who play at the San Paolo Stadium in the southwest of the city, in the Fuorigrotta quarter.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = true;
        c.budget = 0;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Turin
        c = new City();
        c.name = "Turin";
        c.description = "Turin (/tjʊəˈrɪn, ˈtʊərɪn/, Piedmontese: [tyˈriŋ]; Italian: Torino [toˈriːno]; Latin: Augusta Taurinorum, then Taurinum) is a city and an important business and cultural centre in northern Italy. It is the capital city of the Metropolitan City of Turin (an administrative division of Italy) and of the Piedmont region, and was the first capital city of Italy from 1861 to 1865. The city is located mainly on the western bank of the Po River, in front of Susa Valley, and is surrounded by the western Alpine arch and Superga Hill. The population of the city proper is 878,074 (31 July 2018) while the population of the urban area is estimated by Eurostat to be 1.7 million inhabitants. The Turin metropolitan area is estimated by the OECD to have a population of 2.2 million. The city has a rich culture and history, being known for its numerous art galleries, restaurants, churches, palaces, opera houses, piazzas, parks, gardens, theatres, libraries, museums and other venues. Turin is well known for its Renaissance, Baroque, Rococo, Neo-classical, and art Nouveau architecture. Many of Turin's public squares, castles, gardens and elegant palazzi such as the Palazzo Madama, were built between the 16th and 18th centuries. A part of the historical center of Turin was inscribed in the World Heritage List under the name Residences of the Royal House of Savoy. The city used to be a major European political center. From 1563, it was the capital of the Duchy of Savoy, then of the Kingdom of Sardinia ruled by the Royal House of Savoy, and the first capital of the unified Italy (the Kingdom of Italy) from 1861 to 1865. Turin is sometimes called \"the cradle of Italian liberty\" for having been the birthplace and home of notable individuals who contributed to the Risorgimento, such as Cavour. The city currently hosts some of Italy's best universities, colleges, academies, lycea and gymnasia, such as the University of Turin, founded in the 15th century, and the Turin Polytechnic. In addition, the city is home to museums such as the Museo Egizio and the Mole Antonelliana. Turin's attractions make it one of the world's top 250 tourist destinations and the tenth most visited city in Italy in 2008. Even though much of its political significance and importance had been lost by World War II, Turin became a major European crossroad for industry, commerce and trade, and is part of the famous \"industrial triangle\" along with Milan and Genoa. Turin is ranked third in Italy, after Milan and Rome, for economic strength. With a GDP of $58 billion, Turin is the world's 78th richest city by purchasing power. As of 2018, the city has been ranked by GaWC as a Gamma World city. Turin is also home to much of the Italian automotive industry. Turin is well known as the home of the Shroud of Turin, the football teams Juventus F.C. and Torino F.C., the headquarters of automobile manufacturers Fiat, Lancia and Alfa Romeo, and as host of the 2006 Winter Olympics.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = true;
        c.budget = 0;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Brussels
        c = new City();
        c.name = "Brussels";
        c.description = "Brussels (French: Bruxelles [bʁysɛl]; Dutch: Brussel [ˈbrʏsəl]), officially the Brussels-Capital Region (French: Région de Bruxelles-Capitale; Dutch: Brussels Hoofdstedelijk Gewest), is a region of Belgium comprising 19 municipalities, including the City of Brussels, which is the capital of Belgium. The Brussels-Capital Region is located in the central portion of the country and is a part of both the French Community of Belgium and the Flemish Community, but is separate from the Flemish Region (in which it forms an enclave) and the Walloon Region. Brussels is the most densely populated and the richest region in Belgium in terms of GDP per capita. It covers 161 km2 (62 sq mi), a relatively small area compared to the two other regions, and has a population of 1.2 million. The metropolitan area of Brussels counts over 2.1 million people, which makes it the largest in Belgium. It is also part of a large conurbation extending towards Ghent, Antwerp, Leuven and Walloon Brabant, home to over 5 million people. Brussels grew from a small rural settlement on the river Senne to become an important city-region in Europe. Since the end of the Second World War, it has been a major centre for international politics and the home of numerous international organisations, politicians, diplomats and civil servants. Brussels is the de facto capital of the European Union, as it hosts a number of principal EU institutions, including its administrative-legislative, executive-political, and legislative branches (though the judicial branch is located in Luxembourg, and the European Parliament meets for a minority of the year in Strasbourg) and its name is sometimes used metonymically to describe the EU and its institutions. The secretariat of the Benelux and headquarters of NATO are also located in Brussels. As the economic capital of Belgium and one of the top financial centres of Western Europe with Euronext Brussels, it is classified as an Alpha global city. Brussels is a hub for rail, road and air traffic, sometimes earning the moniker \"Crossroads of Europe\". The Brussels Metro is the only rapid transit system in Belgium. In addition, both its airport and railway stations are the largest and busiest in the country. Historically Dutch-speaking, Brussels saw a language shift to French from the late 19th century. The Brussels-Capital Region is officially bilingual in French and Dutch, even though French is now the de facto main language with over 90% of the population speaking it. Brussels is also increasingly becoming multilingual. English is spoken as a second language by nearly a third of the population and a large number of migrants and expatriates speak other languages. Brussels is known for its cuisine and gastronomy, as well as its historical and architectural landmarks; some of them are registered as UNESCO World Heritage sites. Main attractions include its historic Grand Place, Manneken Pis, Atomium, and cultural institutions such as La Monnaie and the Museums of art and History. Because of its long tradition of Belgian comics, Brussels is also hailed as a capital of the comic strip.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Amsterdam
        c = new City();
        c.name = "Amsterdam";
        c.description = "Amsterdam (/ˈæmstərdæm/, UK also /ˌæmstərˈdæm/; Dutch: [ɑmstərˈdɑm]) is the capital city and most populous municipality of the Netherlands. Its status as the capital is mandated by the Constitution of the Netherlands, although it is not the seat of the government, which is The Hague. Amsterdam has a population of 854,047 within the city proper, 1,357,675 in the urban area and 2,410,960 in the metropolitan area. The city is located in the province of North Holland in the west of the country but is not its capital, which is Haarlem. The Amsterdam metropolitan area comprises much of the northern part of the Randstad, one of the larger conurbations in Europe, which has a population of approximately 8.1 million. Amsterdam's name derives from Amstelredamme, indicative of the city's origin around a dam in the river Amstel. Originating as a small fishing village in the late 12th century, Amsterdam became one of the most important ports in the world during the Dutch Golden Age (17th century), as a result of its innovative developments in trade. During that time, the city was the leading centre for finance and trade. In the 19th and 20th centuries the city expanded, and many new neighbourhoods and suburbs were planned and built. The 17th-century canals of Amsterdam and the 19–20th century Defence Line of Amsterdam are on the UNESCO World Heritage List. Since the annexation of the municipality of Sloten in 1921 by the municipality of Amsterdam, the oldest historic part of the city lies in Sloten, dating to the 9th century. As the commercial capital of the Netherlands and one of the top financial centres in Europe, Amsterdam is considered an alpha- world city by the Globalization and World Cities (GaWC) study group. The city is also the cultural capital of the Netherlands. Many large Dutch institutions have their headquarters there, including Philips, AkzoNobel, TomTom and ING. Also, many of the world's largest companies are based in Amsterdam or established their European headquarters in the city, such as leading technology companies Uber, Netflix and Tesla. In 2012, Amsterdam was ranked the second best city to live in by the Economist Intelligence Unit (EIU) and 12th globally on quality of living for environment and infrastructure by Mercer. The city was ranked 4th place globally as top tech hub in the Savills Tech Cities 2019 report (2nd in Europe), and 3rd in innovation by Australian innovation agency 2thinknow in their Innovation Cities Index 2009. The Port of Amsterdam to this day remains the second in the country, and the fifth largest seaport in Europe. Famous Amsterdam residents include the diarist Anne Frank, artists Rembrandt van Rijn and Vincent van Gogh, and philosopher Baruch Spinoza. The Amsterdam Stock Exchange, the oldest stock exchange in the world, is located in the city centre. Amsterdam's main attractions include its historic canals, the Rijksmuseum, the Van Gogh Museum, the Stedelijk Museum, Hermitage Amsterdam, the Anne Frank House, the Scheepvaartmuseum, the Amsterdam Museum, the Heineken Experience, the Royal Palace of Amsterdam, Natura Artis Magistra, Hortus Botanicus Amsterdam, NEMO, the red-light district and many cannabis coffee shops. They draw more than 5 million international visitors annually. The city is also well known for its nightlife and festival activity; several of its nightclubs (Melkweg, Paradiso) are among the world's most famous. It is also one of the world's most multicultural cities, with at least 177 nationalities represented.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Munich
        c = new City();
        c.name = "Munich";
        c.description = "Munich (/ˈmjuːnɪk/; German: München [ˈmʏnçn̩]; Austro-Bavarian: Minga [ˈmɪŋ(ː)ɐ]; Polish: Monachium) is the capital and most populous city of Bavaria, the second most populous German federal state. With a population of around 1.5 million, it is the third-largest city in Germany, after Berlin and Hamburg, as well as the 12th-largest city in the European Union. The city's metropolitan region is home to 6 million people. Straddling the banks of the River Isar (a tributary of the Danube) north of the Bavarian Alps, it is the seat of the Bavarian administrative region of Upper Bavaria, while being the most densely populated municipality in Germany (4,500 people per km²). Munich is the second-largest city in the Bavarian dialect area, after the Austrian capital of Vienna. The city is a global centre of art, science, technology, finance, publishing, culture, innovation, education, business, and tourism and enjoys a very high standard and quality of living, reaching first in Germany and third worldwide according to the 2018 Mercer survey, and being rated the world's most liveable city by the Monocle's Quality of Life Survey 2018. According to the Globalization and World Rankings Research Institute Munich is considered an alpha-world city, as of 2015. Munich is a major international center of engineering, science, innovation, and research, exemplified by the presence of two research universities, a multitude of scientific institutions in the city and its surroundings, and world class technology and science museums like the Deutsches Museum and BMW Museum.. Munich houses many multinational companies and its economy is based on high tech, automobiles, the service sector and creative industries, as well as IT, biotechnology, engineering and electronics among many others. The name of the city is derived from the Old/Middle High German term Munichen, meaning \"by the monks\". It derives from the monks of the Benedictine order, who ran a monastery at the place that was later to become the Old Town of Munich; hence the monk depicted on the city's coat of arms. Munich was first mentioned in 1158. Catholic Munich strongly resisted the Reformation and was a political point of divergence during the resulting Thirty Years' War, but remained physically untouched despite an occupation by the Protestant Swedes. Once Bavaria was established as a sovereign kingdom in 1806, it became a major European centre of arts, architecture, culture and science. In 1918, during the German Revolution, the ruling house of Wittelsbach, which had governed Bavaria since 1180, was forced to abdicate in Munich and a short-lived socialist republic was declared. In the 1920s, Munich became home to several political factions, among them the NSDAP. The first attempt of the Nazi movement to take over the German government in 1923 with the Beer Hall Putsch was stopped by the Bavarian police in Munich with gunfire. After the Nazis' rise to power, Munich was declared their \"Capital of the Movement\". During World War II, Munich was heavily bombed and more than 50% of the entire city and up to 90% of the historic centre were destroyed. After the end of postwar American occupation in 1949, there was a great increase in population and economic power during the years of Wirtschaftswunder, or \"economic miracle\". Unlike many other German cities which were heavily bombed, Munich restored most of its traditional cityscape and hosted the 1972 Summer Olympics. The 1980s brought strong economic growth, high-tech industries and scientific institutions, and population growth. The city is home to major corporations like BMW, Siemens, MAN, Linde, Allianz and MunichRE. Munich is home to many universities, museums and theatres. Its numerous architectural attractions, sports events, exhibitions and its annual Oktoberfest attract considerable tourism. Munich is one of the most prosperous and fastest growing cities in Germany. It is a top-ranked destination for migration and expatriate location. Munich hosts more than 530,000 people of foreign background, making up 37.7% of its population.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 0;
        cityBox.put(c);

        //Bern
        c = new City();
        c.name = "Bern";
        c.description = "Bern or Berne (German: Bern [bɛrn], Alemannic German: Bärn [b̥æːrn], French: Berne [bɛʁn], Italian: Berna [ˈbɛrna], Romansh: Berna [ˈbɛrnɐ]) is the de facto capital of Switzerland, referred to by the Swiss as their \"federal city\", in German Bundesstadt, French Ville Fédérale, and Italian Città Federale.[note 1] With a population of 142,493 (January 2019), Bern is the fifth-most populous city in Switzerland. The Bern agglomeration, which includes 36 municipalities, had a population of 406,900 in 2014. The metropolitan area had a population of 660,000 in 2000. Bern is also the capital of the canton of Bern, the second-most populous of Switzerland's cantons. The official language in Bern is (the Swiss variety of Standard) German, but the most-spoken language is an Alemannic Swiss German dialect, Bernese German. In 1983, the historic old town (in German: Altstadt) in the centre of Bern became a UNESCO World Heritage Site.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Manchester
        c = new City();
        c.name = "Manchester";
        c.description = "Manchester (/ˈmæntʃɪstər, -tʃɛs-/) is a city and metropolitan borough in Greater Manchester, England, with a population of 545,500 as of 2017. It lies within the United Kingdom's second-most populous built-up area, with a population of 3.2 million. It is fringed by the Cheshire Plain to the south, the Pennines to the north and east, and an arc of towns with which it forms a continuous conurbation. The local authority is Manchester City Council. The recorded history of Manchester began with the civilian settlement associated with the Roman fort of Mamucium or Mancunium, which was established in about AD 79 on a sandstone bluff near the confluence of the rivers Medlock and Irwell. It was historically a part of Lancashire, although areas of Cheshire south of the River Mersey were incorporated in the 20th century. The first to be included, Wythenshawe, was added to the city in 1931. Throughout the Middle Ages Manchester remained a manorial township, but began to expand \"at an astonishing rate\" around the turn of the 19th century. Manchester's unplanned urbanisation was brought on by a boom in textile manufacture during the Industrial Revolution, and resulted in it becoming the world's first industrialised city. Manchester achieved city status in 1853. The Manchester Ship Canal opened in 1894, creating the Port of Manchester and directly linking the city to the Irish Sea, 36 miles (58 km) to the west. Its fortune declined after the Second World War, owing to deindustrialisation, but the IRA bombing in 1996 led to extensive investment and regeneration. In 2014, the Globalisation and World Cities Research Network ranked Manchester as a beta world city, the highest-ranked British city apart from London. Manchester is the third-most visited city in the UK, after London and Edinburgh. It is notable for its architecture, culture, musical exports, media links, scientific and engineering output, social impact, sports clubs and transport connections. Manchester Liverpool Road railway station was the world's first inter-city passenger railway station; scientists first split the atom, developed the stored-program computer and produced graphene in the city. Manchester hosted the 2002 Commonwealth Games.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Oxford
        c = new City();
        c.name = "Oxford";
        c.description = "Oxford (/ˈɒksfərd/ OKS-fərd) is a university city in south central England and the county town of Oxfordshire. With a population of approximately 155,000, it is the 52nd largest city in the United Kingdom, with one of the fastest growing populations in the UK, and it remains the most ethnically diverse area in Oxfordshire county. The city is 51 miles (82 km) from London, 61 miles (98 km) from Bristol, 59 miles (95 km) from Southampton, 57 miles (92 km) from Birmingham and 24 miles (39 km) from Reading. The city is known worldwide as the home of the University of Oxford, the oldest university in the English-speaking world. Buildings in Oxford demonstrate notable examples of every English architectural period since the late Saxon period. Oxford is known as the \"City of Dreaming Spires\", a term coined by poet Matthew Arnold. Oxford has a broad economic base. Its industries include motor manufacturing, education, publishing and a large number of information technology and science-based businesses, some being academic offshoots.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 1;
        c.temperature = 1;
        cityBox.put(c);

        //Dublin
        c = new City();
        c.name = "Dublin";
        c.description = "Dublin (/ˈdʌblɪn/; Irish: Baile Átha Cliath [ˈbˠalʲə aːhə ˈclʲiə; ˌbʲlʲaː ˈclʲiə]) is the capital and largest city of Ireland. It is on the east coast of Ireland, in the province of Leinster, at the mouth of the River Liffey, and is bordered on the south by the Wicklow Mountains. It has an urban area population of 1,173,179, while the population of the Dublin Region (formerly County Dublin), as of 2016, was 1,347,359, and the population of the Greater Dublin area was 1,904,806. There is archaeological debate regarding precisely where Dublin was established by the Gaels in or before the 7th century AD. Later expanded as a Viking settlement, the Kingdom of Dublin, the city became Ireland's principal settlement following the Norman invasion. The city expanded rapidly from the 17th century and was briefly the second largest city in the British Empire before the Acts of Union in 1800. Following the partition of Ireland in 1922, Dublin became the capital of the Irish Free State, later renamed Ireland. Dublin is a historical and contemporary centre for education, the arts, administration and industry. As of 2018 the city was listed by the Globalization and World Cities Research Network (GaWC) as a global city, with a ranking of \"Alpha −\", which places it amongst the top thirty cities in the world.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 0;
        cityBox.put(c);

        //Washington
        c = new City();
        c.name = "Washington";
        c.description = "Washington, D.C., formally the District of Columbia and commonly referred to as Washington or D.C., is the capital of the United States. Founded after the American Revolution as the seat of government of the newly independent country, Washington was named after George Washington, first President of the United States and Founding Father. As the seat of the United States federal government and several international organizations, Washington is an important world political capital. The city is also one of the most visited cities in the world, with more than 20 million tourists annually. The signing of the Residence Act on July 16, 1790, approved the creation of a capital district located along the Potomac River on the country's East Coast. The U.S. Constitution provided for a federal district under the exclusive jurisdiction of the U.S. Congress, and the District is therefore not a part of any state. The states of Maryland and Virginia each donated land to form the federal district, which included the pre-existing settlements of Georgetown and Alexandria. The City of Washington was founded in 1791 to serve as the new national capital. In 1846, Congress returned the land originally ceded by Virginia; in 1871, it created a single municipal government for the remaining portion of the District. Washington had an estimated population of 702,455 as of July 2018, making it the 20th most populous city in the United States. Commuters from the surrounding Maryland and Virginia suburbs raise the city's daytime population to more than one million during the workweek. Washington's metropolitan area, the country's sixth largest, had a 2017 estimated population of 6.2 million residents. All three branches of the U.S. federal government are centered in the District: Congress (legislative), president (executive), and the U.S. Supreme Court (judicial). Washington is home to many national monuments, and museums, primarily situated on or around the National Mall. The city hosts 177 foreign embassies as well as the headquarters of many international organizations, trade unions, non-profit, lobbying groups, and professional associations, including the World Bank Group, the International Monetary Fund (IMF), the Organization of American States, AARP, the National Geographic Society, the Human Rights Campaign, the International Finance Corporation, and the American Red Cross. A locally elected mayor and a 13‑member council have governed the District since 1973. However, Congress maintains supreme authority over the city and may overturn local laws. D.C. residents elect a non-voting, at-large congressional delegate to the House of Representatives, but the District has no representation in the Senate. The District receives three electoral votes in presidential elections as permitted by the Twenty-third Amendment to the United States Constitution, ratified in 1961.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Los Angeles
        c = new City();
        c.name = "Los Angeles";
        c.description = "Los Angeles (/lɔːs ˈændʒələs/; Spanish: Los Ángeles), officially the City of Los Angeles and often known by its initials L.A., is the most populous city in California, the second most populous city in the United States, after New York City, and the third most populous city in North America. With an estimated population of four million, Los Angeles is the cultural, financial, and commercial center of Southern California. The city is known for its Mediterranean climate, ethnic diversity, Hollywood and the entertainment industry, and its sprawling metropolis. Los Angeles is the largest city on the West Coast of North America. Los Angeles is in a large basin bounded by the Pacific Ocean on one side and by mountains as high as 10,000 feet (3,000 m) on the other. The city proper, which covers about 469 square miles (1,210 km2), is the seat of Los Angeles County, the most populated county in the country. Los Angeles is also the principal city of the Los Angeles metropolitan area, the second largest in the United States after that of New York City, with a population of 13.1 million. It is part of the Los Angeles-Long Beach combined statistical area, also the nation's second most populous area with a 2015 estimated population of 18.7 million. Los Angeles is one of the most substantial economic engines within the United States, with a diverse economy in a broad range of professional and cultural fields. Los Angeles is also famous as the home of Hollywood, a major center of the world entertainment industry. A global city, it has been ranked 6th in the Global Cities Index and 9th in the Global Economic Power Index. The Los Angeles metropolitan area also has a gross metropolitan product of $1.044 trillion (as of 2017), making it the third-largest in the world, after the Tokyo and New York metropolitan areas. Los Angeles hosted the 1932 and 1984 Summer Olympics and will host the event for a third time in 2028. The city also hosted the Miss Universe pageant twice, in 1990 and 2006, and was one of 9 American cities to host the 1994 FIFA men's soccer World Cup and one of 8 to host the 1999 FIFA women's soccer World Cup, hosting the final match for both tournaments. Historically home to the Chumash and Tongva, Los Angeles was claimed by Juan Rodríguez Cabrillo for Spain in 1542 along with the rest of what would become Alta California. The city was officially founded on September 4, 1781, by Spanish governor Felipe de Neve. It became a part of Mexico in 1821 following the Mexican War of Independence. In 1848, at the end of the Mexican–American War, Los Angeles and the rest of California were purchased as part of the Treaty of Guadalupe Hidalgo, becoming part of the United States. Los Angeles was incorporated as a municipality on April 4, 1850, five months before California achieved statehood. The discovery of oil in the 1890s brought rapid growth to the city. The completion of the Los Angeles Aqueduct in 1913, delivering water from Eastern California, later assured the city's continued rapid growth.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Mexico City
        c = new City();
        c.name = "Mexico City";
        c.description = "Mexico City, or the City of Mexico (Spanish: Ciudad de México, American Spanish: [sjuˈða(ð) ðe ˈmexiko]; abbreviated as CDMX, Nahuatl languages: Āltepētl Mēxihco), is the capital of Mexico and the most populous city in North America. Mexico City is one of the most important cultural and financial centres in the Americas. It is located in the Valley of Mexico (Valle de México), a large valley in the high plateaus in the center of Mexico, at an altitude of 2,240 meters (7,350 ft). The city has 16 boroughs. The 2009 population for the city proper was approximately 8.84 million people, with a land area of 1,485 square kilometers (573 sq mi). According to the most recent definition agreed upon by the federal and state governments, the population of Greater Mexico City is 21.3 million, which makes it the largest metropolitan area of the Western Hemisphere, the eleventh-largest agglomeration (2017), and the largest Spanish-speaking city in the world. Greater Mexico City has a GDP of $411 billion in 2011, making Greater Mexico City one of the most productive urban areas in the world. The city was responsible for generating 15.8% of Mexico's GDP, and the metropolitan area accounted for about 22% of total national GDP. If it were an independent country, in 2013, Mexico City would be the fifth-largest economy in Latin America, five times as large as Costa Rica and about the same size as Peru. Mexico’s capital is both the oldest capital city in the Americas and one of two founded by Native Americans, the other being Quito, Ecuador. The city was originally built on an island of Lake Texcoco by the Aztecs in 1325 as Tenochtitlan, which was almost completely destroyed in the 1521 siege of Tenochtitlan and subsequently redesigned and rebuilt in accordance with the Spanish urban standards. In 1524, the municipality of Mexico City was established, known as México Tenochtitlán, and as of 1585, it was officially known as Ciudad de México (Mexico City). Mexico City was the political, administrative, and financial center of a major part of the Spanish colonial empire. After independence from Spain was achieved, the federal district was created in 1824. After years of demanding greater political autonomy, residents were finally given the right to elect both a Head of Government and the representatives of the unicameral Legislative Assembly by election in 1997. Ever since, the left-wing Party of the Democratic Revolution (PRD) has controlled both of them. The city has several progressive policies, such as abortion on request, a limited form of euthanasia, no-fault divorce, and same-sex marriage. On January 29, 2016, it ceased to be the Federal District (Spanish: Distrito Federal or D.F.), and is now officially known as Ciudad de México (or CDMX), with a greater degree of autonomy. A clause in the Constitution of Mexico, however, prevents it from becoming a state, as it is the seat of power in the country, unless the capital of the country were relocated elsewhere.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Agrigento
        c = new City();
        c.name = "Agrigento";
        c.description = "Agrigento (Italian: [aɡriˈdʒɛnto]; Sicilian: Girgenti [dʒɪɾˈdʒɛndɪ] or Giurgenti [dʒʊɾˈdʒɛndɪ]) is a city on the southern coast of Sicily, Italy and capital of the province of Agrigento. It is renowned as the site of the ancient Greek city of Akragas (Ἀκράγας; also known as Agrigentum or Acragas in Latin and Kirkent or Jirjent in Arabic), one of the leading cities of Magna Graecia during the golden age of Ancient Greece with population estimates in the range of 200,000 to 800,000 before 406 BC.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = true;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Otranto
        c = new City();
        c.name = "Otranto";
        c.description = "Otranto (Italian pronunciation: [ˈɔːtranto]) (Salentino: Uṭṛàntu; Griko: Δερεντό, translit. Derentò; Ancient Greek: Ὑδροῦς, translit. Hudroûs; Latin: Hydruntum) is a town and comune in the province of Lecce (Apulia, Italy), in a fertile region once famous for its breed of horses. It is located on the east coast of the Salento peninsula. The Strait of Otranto, to which the city gives its name, connects the Adriatic Sea with the Ionian Sea and separates Italy from Albania. The harbour is small and has little trade. The lighthouse Faro della Palascìa, at approximately 5 kilometres (3 miles) southeast of Otranto, marks the most easterly point of the Italian mainland. About 50 kilometres (31 mi) south lies the promontory of Santa Maria di Leuca (so called since ancient times from its white cliffs, leukos being Greek for white), the southeastern extremity of Italy, the ancient Promontorium lapygium or Sallentinum. The district between this promontory and Otranto is thickly populated and very fertile.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = true;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Gallipoli
        c = new City();
        c.name = "Gallipoli";
        c.description = "Gallipoli (Ancient Greek: Καλλίπολις, translit. Kallípolis, lit. 'Beautiful City'; Salentino: Caḍḍìpuli) is a southern Italian town and comune in the province of Lecce, in Apulia. In 2014, it had a population of 31,862. The town is located by the Ionian Sea, on the west coast of the Salentina Peninsula. The town of Gallipoli is divided into two parts, the modern and the old city. The new town includes all the newest buildings including a skyscraper. The old town is located on a limestone island, linked to the mainland by a bridge built in the 16th century. According to a legend, the city was founded in ancient times by Idomeneus of Crete. Pliny the Elder attributes the foundation to the Senones Gauls, while more likely it was a Messapic settlement. Historically, what is known is that Gallipoli was a city of the Greater Greece, ruling over a large territory including today's Porto Cesareo. In 265 BC it sided with Pyrrhus and Taranto against ancient Rome, suffering a defeat which relegated it to a Roman colony (later a municipium).";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Vieste
        c = new City();
        c.name = "Vieste";
        c.description = "Vieste (Viestano: Vìst) is a town, comune and former Catholic bishopric in the province of Foggia, in the Apulia region of southeast Italy. A marine resort in Gargano, Vieste has received Blue Flags for the purity of its waters from the Foundation for Environmental Education. The area covered by the comune is included in the Gargano National Park. In mediaeval times, the port was frequently attacked by pirates, Saracens and other enemies of the Kingdom of Naples. The town is bordered by Mattinata, Monte Sant'Angelo, Peschici and Vico del Gargano. The coast is interesting from a geological point of view. Next to the town there are two large, straight beaches. The rest of the coast is made up of gulfs and small, hidden sandy beaches. Erosion by water and wind has shaped the calcareous rock into grottoes and arches. Since the coast is steep, some of the finest sights can be reached only by sea.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = true;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Geneva
        c = new City();
        c.name = "Geneva";
        c.description = "Geneva (/dʒɪˈniːvə/; French: Genève [ʒənɛv]; Arpitan: Genèva [dzəˈnɛva]; German: Genf [ɡɛnf]; Italian: Ginevra [dʒiˈneːvra]; Romansh: Genevra) is the second-most populous city in Switzerland (after Zürich) and the most populous city of Romandy, the French-speaking part of Switzerland. Situated where the Rhône exits Lake Geneva, it is the capital of the Republic and Canton of Geneva. The municipality (ville de Genève) has a population (as of December 2017) of 200,548, and the canton (essentially the city and its inner-ring suburbs) has 495,249 residents. In 2014, the compact agglomération du Grand Genève had 946,000 inhabitants in 212 communities in both Switzerland and France. Within Swiss territory, the commuter area named \"Métropole lémanique\" contains a population of 1.26 million. This area is essentially spread east from Geneva towards the Riviera area (Vevey, Montreux) and north-east towards Yverdon-les-Bains, in the neighbouring canton of Vaud. Geneva is a global city, a financial centre, and a worldwide centre for diplomacy due to the presence of numerous international organizations, including the headquarters of many agencies of the United Nations and the Red Cross. Geneva hosts the highest number of international organizations in the world. It is also where the Geneva Conventions were signed, which chiefly concern the treatment of wartime non-combatants and prisoners of war. In 2017, Geneva was ranked as the world's fifteenth most important financial centre for competitiveness by the Global Financial Centres Index, fifth in Europe behind London, Zürich, Frankfurt and Luxembourg. In 2019 Geneva was ranked among the ten most liveable cities in the world by Mercer together with Zürich and Basel. The city has been referred to as the world's most compact metropolis and the \"Peace Capital\". In 2017, Geneva was ranked as the seventh most expensive city in the world. Geneva was ranked third in purchasing power in a global cities ranking by UBS in 2018.";
        c.kinds.add(kindManager.getKind(1));
        c.kinds.add(kindManager.getKind(2));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 1;
        c.temperature = 0;
        cityBox.put(c);

        //Dubai
        c = new City();
        c.name = "Dubai";
        c.description = "Dubai (/duːˈbaɪ/ doo-BY; Arabic: دبي\u200E Dubay, Gulf Arabic: Arabic pronunciation: [dʊˈbɑj]) is the largest and most populous city in the United Arab Emirates (UAE). On the southeast coast of the Persian Gulf, it is the capital of the Emirate of Dubai, one of the seven emirates that make up the country. Dubai is a global city and business hub of the Middle East. It is also a major global transport hub for passengers and cargo. Oil revenue helped accelerate the development of the city, which was already a major mercantile hub, but Dubai's oil reserves are limited and production levels are low: today, less than 5% of the emirate's revenue comes from oil. A growing centre for regional and international trade since the early 20th century, Dubai's economy today relies on revenues from trade, tourism, aviation, real estate, and financial services. Dubai has attracted world attention through large construction projects and sports events, in particular the world's tallest building, the Burj Khalifa. As of 2012, Dubai was the most expensive city in the Middle East. In 2014, Dubai's hotel rooms were rated as the second most expensive in the world.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Maldive
        c = new City();
        c.name = "Maldive";
        c.description = "The Maldives (/ˈmɔːldiːvz/, US: /ˈmɔːldaɪvz/; Dhivehi: ދިވެހިރާއްޖެ Dhivehi Raajje), officially the Republic of Maldives, are an Asian country, located in the Indian Ocean, situated in the Arabian Sea. The country lies southwest of Sri Lanka and India, about 1,000 kilometres (620 mi) from the Asian continent. The chain of 26 atolls stretches from Ihavandhippolhu Atoll in the north to the Addu City in the south. Comprising a territory spanning roughly 298 square kilometres (115 sq mi), the Maldives is one of the world's most geographically dispersed sovereign states as well as the smallest Asian country by land area and population, with around 427,756 inhabitants. Malé is the capital and a populated city, traditionally called the \"King's Island\" for its central location. The Maldives archipelago is located on the Chagos-Laccadive Ridge, a vast submarine mountain range in the Indian Ocean, which also forms a terrestrial ecoregion, together with the Chagos Archipelago and Lakshadweep. With an average ground-level elevation of 1.5 metres (4 ft 11 in) above sea level, it is the world's lowest country, with even its highest natural point being the lowest in the world, at 5.1 metres (17 ft). Due to the consequent risks posed by rising sea levels, the government pledged in 2009 to make the Maldives a carbon-neutral country by 2019. Islam was introduced to the Maldivian archipelago in the 12th century which was consolidated as a sultanate, developing strong commercial and cultural ties with Asia and Africa. From the mid-16th-century, the region came under the increasing influence of European colonial powers, with the Maldives becoming a British protectorate in 1887. Independence from the United Kingdom was achieved in 1965 and a presidential republic was established in 1968 with an elected People's Majlis. The ensuing decades have been characterised by political instability, efforts at democratic reform, and environmental challenges posed by climate change. The Maldives is a founding member of the South Asian Association for Regional Cooperation (SAARC). It is also a member of the United Nations, the Organization of Islamic Cooperation, and the Non Aligned Movement. The World Bank classifies the Maldives as having an upper middle income economy. Fishing has historically been the dominant economic activity, and remains the largest sector by far, followed by the rapidly growing tourism industry. Maldives is rated \"high\" on the Human Development Index, with its per capita income significantly higher than other SAARC nations. The Maldives was a Commonwealth republic from July 1982 until its withdrawal from the Commonwealth in October 2016 in protest of international criticism of its records in relation to corruption and human rights.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Mykonos
        c = new City();
        c.name = "Mykonos";
        c.description = "Mykonos (/ˈmɪkəˌnɒs/, /ˈmɪkəˌnoʊs/; Greek: Μύκονος [ˈmikonos]) is a Greek island, part of the Cyclades, lying between Tinos, Syros, Paros and Naxos. The island spans an area of 85.5 square kilometres (33.0 sq mi) and rises to an elevation of 341 metres (1,119 feet) at its highest point. There are 10,134 inhabitants (2011 census), most of whom live in the largest town, Mykonos, which lies on the west coast. The town is also known as Chora (i.e. the Town in Greek, following the common practice in Greece when the name of the island itself is the same as the name of the principal town). Mykonos's nickname is \"The Island of the Winds\". Tourism is a major industry and Mykonos is known for its vibrant nightlife and has many establishments catering for the LGBT community.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Athens
        c = new City();
        c.name = "Athens";
        c.description = "Athens (/ˈæθɪnz/; Greek: Αθήνα, Athína [aˈθina]; Ancient Greek: Ἀθῆναι, Athênai [a.tʰɛ̂ː.nai̯]) is the capital and largest city of Greece. Athens dominates the Attica region and is one of the world's oldest cities, with its recorded history spanning over 3,400 years and its earliest human presence starting somewhere between the 11th and 7th millennium BC. Classical Athens was a powerful city-state that emerged in conjunction with the seagoing development of the port of Piraeus, which had been a distinct city prior to its 5th century BC incorporation with Athens. A center for the arts, learning and philosophy, home of Plato's Academy and Aristotle's Lyceum, it is widely referred to as the cradle of Western civilization and the birthplace of democracy, largely because of its cultural and political impact on the European continent, and in particular the Romans. In modern times, Athens is a large cosmopolitan metropolis and central to economic, financial, industrial, maritime, political and cultural life in Greece. In 2012, Athens was ranked the world's 39th richest city by purchasing power and the 67th most expensive in a UBS study. Athens is a global city and one of the biggest economic centres in southeastern Europe. It has a large financial sector, and its port Piraeus is both the largest passenger port in Europe, and the second largest in the world. while at the same time being the sixth busiest passenger port in Europe. The Municipality of Athens (also City of Athens) had a population of 664,046 (in 2011) within its administrative limits, and a land area of 38.96 km2 (15.04 sq mi). The urban area of Athens (Greater Athens and Greater Piraeus) extends beyond its administrative municipal city limits, with a population of 3,090,508 (in 2011) over an area of 412 km2 (159 sq mi). According to Eurostat in 2011, the functional urban area (FUA) of Athens was the 9th most populous FUA in the European Union (the 6th most populous capital city of the EU), with a population of 3.8 million people. Athens is also the southernmost capital on the European mainland. The heritage of the classical era is still evident in the city, represented by ancient monuments and works of art, the most famous of all being the Parthenon, considered a key landmark of early Western civilization. The city also retains Roman and Byzantine monuments, as well as a smaller number of Ottoman monuments. Athens is home to two UNESCO World Heritage Sites, the Acropolis of Athens and the medieval Daphni Monastery. Landmarks of the modern era, dating back to the establishment of Athens as the capital of the independent Greek state in 1834, include the Hellenic Parliament and the so-called \"architectural trilogy of Athens\", consisting of the National Library of Greece, the National and Kapodistrian University of Athens and the Academy of Athens. Athens is also home to several museums and cultural institutions, such as the National Archeological Museum, featuring the world's largest collection of ancient Greek antiquities, the Acropolis Museum, the Museum of Cycladic art, the Benaki Museum and the Byzantine and Christian Museum. Athens was the host city of the first modern-day Olympic Games in 1896, and 108 years later it welcomed home the 2004 Summer Olympics, making it one of only a handful of cities to have hosted the Olympics more than once.";
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Dusseldorf
        c = new City();
        c.name = "Dusseldorf";
        c.description = "Düsseldorf (UK: /ˈdʊsəldɔːrf/, US: /ˈd(j)uːsəldɔːrf/, German: [ˈdʏsl̩dɔɐ̯f]; often Dusseldorf in English sources; Low Franconian and Ripuarian: Düsseldörp [ˈdʏsl̩dœɐ̯p]; archaic Dutch: Dusseldorp) is the capital and second-largest city of the most populous German federal state of North Rhine-Westphalia after Cologne, as well as the seventh-largest city in Germany. with a population of 617,280. At the confluence of the Rhine and its tributary Düssel, the city lies in the centre of both the Rhine-Ruhr and the Rhineland Metropolitan Regions with the Cologne Bonn region to its south and the Ruhr to its north. Most of the city lies on the right bank of the Rhine (as opposed to Cologne, whose city centre lies on the river's left bank). The city is the largest in the German Low Franconian dialect area (closely related to Dutch). \"Dorf\" meaning \"village\" in German, the \"-dorf\" suffix (English cognate: thorp) is unusual in the German-speaking area for a settlement of Düsseldorf's size. Mercer's 2012 Quality of Living survey ranked Düsseldorf the sixth most livable city in the world. Düsseldorf Airport is Germany's third-busiest airport after those of Frankfurt and Munich, serving as the most important international airport for the inhabitants of the densely populated Ruhr, Germany's largest urban area. Düsseldorf is an international business and financial centre, renowned for its fashion and trade fairs, and is headquarters to one Fortune Global 500 and two DAX companies. Messe Düsseldorf organises nearly one fifth of premier trade shows. As second largest city of the Rhineland, Düsseldorf holds Rhenish Carnival celebrations every year in February/March, the Düsseldorf carnival celebrations being the third most popular in Germany after those held in Cologne and Mainz. There are 22 institutions of higher education in the city including the Heinrich-Heine-Universität Düsseldorf, the university of applied sciences (Hochschule Düsseldorf), the academy of arts (Kunstakademie Düsseldorf) (Joseph Beuys, Emanuel Leutze, August Macke, Gerhard Richter, Sigmar Polke, and Andreas Gursky), and the university of music (Robert-Schumann-Musikhochschule Düsseldorf). The city is also known for its pioneering influence on electronic/experimental music (Kraftwerk) and its Japanese community.";
        c.kinds.add(kindManager.getKind(2));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 1;
        c.temperature = 0;
        cityBox.put(c);

        //Ibiza
        c = new City();
        c.name = "Ibiza";
        c.description = "Ibiza (Catalan: Eivissa) is a Spanish island in the Mediterranean Sea off the eastern coast of Spain. It is 150 kilometres (93 miles) from the city of Valencia. It is the third largest of the Balearic Islands, an autonomous community of Spain. Its largest settlements are Ibiza Town (Catalan: Vila d'Eivissa, or simply Vila), Santa Eulària des Riu, and Sant Antoni de Portmany. Its highest point, called Sa Talaiassa (or Sa Talaia), is 475 metres (1,558 feet) above sea level. Ibiza has become well known for its association with nightlife, electronic dance music that originated on the island, and for the summer club scene, all of which attract large numbers of tourists drawn to that type of holiday. Several years before 2010, the island's government and the Spanish Tourist Office had been working to promote more family-oriented tourism, with the police closing down clubs that played music at late night hours, but by 2010 this policy was reversed. Around 2015 it was resumed. Ibiza is a UNESCO World Heritage Site. Ibiza and the nearby island of Formentera to its south are called the Pine Islands, or \"Pityuses\".";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Miami
        c = new City();
        c.name = "Miami";
        c.description = "Miami, officially the City of Miami, is the cultural, economic and financial center of South Florida. Miami is the seat of Miami-Dade County, the most populous county in Florida. The city covers an area of about 56.6 square miles (147 km2), between the Everglades to the west and Biscayne Bay on the east; with a 2017 estimated population of 463,347, Miami is the sixth most densely populated major city in the United States. The Miami metropolitan area is home to 6.1 million people and the seventh-largest metropolitan area in the nation. Miami's metro area is the second-most populous metropolis in the southeastern United States and fourth-largest urban area in the U.S. Miami has the third tallest skyline in the United States with over 300 high-rises, 80 of which stand taller than 400 feet. Miami is a major center, and a leader in finance, commerce, culture, media, entertainment, the arts, and international trade. The Miami Metropolitan Area is by far the largest urban economy in Florida and the 12th largest in the United States with a GDP of $344.9 billion as of 2017. In 2012, Miami was classified as an Alpha − level world city in the World Cities Study Group's inventory. In 2010, Miami ranked seventh in the United States and 33rd among global cities in terms of business activity, human capital, information exchange, cultural experience, and political engagement. In 2008, Forbes magazine ranked Miami \"America's Cleanest City\", for its year-round good air quality, vast green spaces, clean drinking water, clean streets, and citywide recycling programs. According to a 2009 UBS study of 73 world cities, Miami was ranked as the richest city in the United States, and the world's seventh-richest city in terms of purchasing power. Miami is nicknamed the \"Capital of Latin America\" and is the largest city with a Cuban-American plurality. Greater Downtown Miami has one of the largest concentrations of international banks in the United States, and is home to many large national and international companies. The Civic Center is a major center for hospitals, research institutes, medical centers, and biotechnology industries. For more than two decades, the Port of Miami, known as the \"Cruise Capital of the World\", has been the number one cruise passenger port in the world. It accommodates some of the world's largest cruise ships and operations, and is the busiest port in both passenger traffic and cruise lines. Metropolitan Miami is also a major tourism hub in the southeastern U.S. for international visitors, ranking number two in the country after New York City.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //San Francisco
        c = new City();
        c.name = "San Francisco";
        c.description = "San Francisco (SF; /ˌsæn frənˈsɪskoʊ, fræn-/, Spanish: [sam fɾanˈsisko]; Spanish for 'Saint Francis'), officially the City and County of San Francisco, is the cultural, commercial, and financial center of Northern California. San Francisco is the 13th-most populous city in the United States, and the fourth-most populous in California, with 884,363 residents as of 2017. It covers an area of about 46.89 square miles (121.4 km2), mostly at the north end of the San Francisco Peninsula in the San Francisco Bay Area, making it the second-most densely populated large US city, and the fifth-most densely populated U.S. county, behind only four of the five New York City boroughs. San Francisco is also part of the fifth-most populous primary statistical area in the United States, the San Jose–San Francisco–Oakland, CA Combined Statistical Area (9.7 million residents). As of 2017, it was the seventh-highest income county in the United States, with a per capita personal income of $119,868. As of 2015, San Francisco proper had a GDP of $154.2 billion, and a GDP per capita of $177,968. The San Francisco CSA was the country's third-largest urban economy as of 2017, with a GDP of $907 billion. Of the 500+ primary statistical areas in the US, the San Francisco CSA had among the highest GDP per capita in 2017, at $93,938. San Francisco was ranked 14th in the world and third in the United States on the Global Financial Centres Index as of September 2018. San Francisco was founded on June 29, 1776, when colonists from Spain established Presidio of San Francisco at the Golden Gate and Mission San Francisco de Asís a few miles away, all named for St. Francis of Assisi. The California Gold Rush of 1849 brought rapid growth, making it the largest city on the West Coast at the time. San Francisco became a consolidated city-county in 1856. San Francisco's status as the West Coast's largest city peaked between 1870 and 1900, when around 25% of California's population resided in the city proper. After three-quarters of the city was destroyed by the 1906 earthquake and fire, San Francisco was quickly rebuilt, hosting the Panama-Pacific International Exposition nine years later. In World War II, San Francisco was a major port of embarkation for service members shipping out to the Pacific Theater. It then became the birthplace of the United Nations in 1945. After the war, the confluence of returning servicemen, significant immigration, liberalizing attitudes, along with the rise of the \"hippie\" counterculture, the Sexual Revolution, the Peace Movement growing from opposition to United States involvement in the Vietnam War, and other factors led to the Summer of Love and the gay rights movement, cementing San Francisco as a center of liberal activism in the United States. Politically, the city votes strongly along liberal Democratic Party lines. A popular tourist destination, San Francisco is known for its cool summers, fog, steep rolling hills, eclectic mix of architecture, and landmarks, including the Golden Gate Bridge, cable cars, the former Alcatraz Federal Penitentiary, Fisherman's Wharf, and its Chinatown district. San Francisco is also the headquarters of five major banking institutions and various other companies such as Levi Strauss & Co., Gap Inc., Fitbit, Salesforce.com, Dropbox, Reddit, Square, Inc., Dolby, Airbnb, Weebly, Pacific Gas and Electric Company, Yelp, Pinterest, Twitter, Uber, Lyft, Mozilla, Wikimedia Foundation, Craigslist, and Weather Underground. It is home to a number of educational and cultural institutions, such as the University of San Francisco (USF), University of California, San Francisco (UCSF), San Francisco State University (SFSU), the De Young Museum, the San Francisco Museum of Modern art, and the California Academy of Sciences. As of 2019, San Francisco is the highest rated American city on world liveability rankings.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Cairo
        c = new City();
        c.name = "Cairo";
        c.description = "Cairo (/ˈkaɪroʊ/ KY-roh; Arabic: القاهرة\u200E, translit. al-Qāhirah, pronounced [ælˈqɑːhɪɾɑ]; Coptic: ⲕⲁϣⲣⲱⲙⲓ, translit. Kashromi) is the capital of Egypt. The city's metropolitan area is one of the largest in Africa, the largest in the Middle East, and the 15th-largest in the world, and is associated with ancient Egypt, as the famous Giza pyramid complex and the ancient city of Memphis are located in its geographical area. Located near the Nile Delta, modern Cairo was founded in 969 CE by the Fatimid dynasty, but the land composing the present-day city was the site of ancient national capitals whose remnants remain visible in parts of Old Cairo. Cairo has long been a centre of the region's political and cultural life, and is titled \"the city of a thousand minarets\" for its preponderance of Islamic architecture. Cairo is considered a World City with a \"Beta +\" classification according to GaWC. Cairo has the oldest and largest film and music industries in the Middle East, as well as the world's second-oldest institution of higher learning, Al-Azhar University. Many international media, businesses, and organizations have regional headquarters in the city; the Arab League has had its headquarters in Cairo for most of its existence. With a population of over 9 million spread over 3,085 square kilometers (1,191 sq mi), Cairo is by far the largest city in Egypt. An additional 9.5 million inhabitants live in close proximity to the city. Cairo, like many other megacities, suffers from high levels of pollution and traffic. Cairo's metro, one of two in Africa (the other being in Algiers, Algeria), ranks among the fifteen busiest in the world, with over 1 billion annual passenger rides. The economy of Cairo was ranked first in the Middle East in 2005, and 43rd globally on Foreign Policy's 2010 Global Cities Index.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Instabul
        c = new City();
        c.name = "Istanbul";
        c.description = "Istanbul (UK: /ˌɪstænˈbʊl, -ˈbuːl/, also US: /-stɑːn-, -stən-, ˈɪstənb-, ɪˈstɑːnbʊl/; Turkish: İstanbul [isˈtanbuɫ]), formerly known as Byzantium and Constantinople, is the most populous city in Turkey and the country's economic, cultural and historic center. Istanbul is a transcontinental city in Eurasia, straddling the Bosporus strait (which separates Europe and Asia) between the Sea of Marmara and the Black Sea. Its commercial and historical center lies on the European side and about a third of its population lives in suburbs on the Asian side of the Bosporus. With a total population of around 15 million residents in its metropolitan area, Istanbul is one of the world's most populous cities, ranking as the world's fourth largest city proper and the largest European city. The city is the administrative center of the Istanbul Metropolitan Municipality (coterminous with Istanbul Province). Istanbul is viewed as a bridge between the East and West. Founded under the name of Byzantion (Βυζάντιον) on the Sarayburnu promontory around 660 BCE, the city grew in size and influence, becoming one of the most important cities in history. After its reestablishment as Constantinople in 330 CE, it served as an imperial capital for almost 16 centuries, during the Roman/Byzantine (330–1204), Latin (1204–1261), Palaiologos Byzantine (1261–1453) and Ottoman (1453–1922) empires. It was instrumental in the advancement of Christianity during Roman and Byzantine times, before the Ottomans conquered the city in 1453 CE and transformed it into an Islamic stronghold and the seat of the Ottoman Caliphate. The city's strategic position on the historic Silk Road, rail networks to Europe and the Middle East, and the only sea route between the Black Sea and the Mediterranean have produced a cosmopolitan populace. While Ankara was chosen instead as the new Turkish capital after the Turkish War of Independence, and the city's name was changed to Istanbul, the city has maintained its prominence in geopolitical and cultural affairs. The population of the city has increased tenfold since the 1950s, as migrants from across Anatolia have moved in and city limits have expanded to accommodate them. Arts, music, film, and cultural festivals were established towards the end of the 20th century and continue to be hosted by the city today. Infrastructure improvements have produced a complex transportation network in the city. Approximately 12.56 million foreign visitors arrived in Istanbul in 2015, five years after it was named a European Capital of Culture, making the city the world's fifth most popular tourist destination. The city's biggest attraction is its historic center, partially listed as a UNESCO World Heritage Site, and its cultural and entertainment hub is across the city's natural harbor, the Golden Horn, in the Beyoğlu district. Considered a global city, Istanbul has one of the fastest-growing metropolitan economies in the world. It hosts the headquarters of many Turkish companies and media outlets and accounts for more than a quarter of the country's gross domestic product. Hoping to capitalize on its revitalization and rapid expansion, Istanbul has bid for the Summer Olympics five times in twenty years.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Sydney
        c = new City();
        c.name = "Sydney";
        c.description = "Sydney (/ˈsɪdni/ SID-nee) is the state capital of New South Wales and the most populous city in Australia and Oceania. Located on Australia's east coast, the metropolis surrounds Port Jackson and extends about 70 km (43.5 mi) on its periphery towards the Blue Mountains to the west, Hawkesbury to the north, the Royal National Park to the south and Macarthur to the south-west. Sydney is made up of 658 suburbs, 40 local government areas and 15 contiguous regions. Residents of the city are known as \"Sydneysiders\". As of June 2017, Sydney's estimated metropolitan population was 5,230,330 and is home to approximately 65% of the state's population. Indigenous Australians have inhabited the Sydney area for at least 30,000 years, and thousands of engravings remain throughout the region, making it one of the richest in Australia in terms of Aboriginal archaeological sites. During his first Pacific voyage in 1770, Lieutenant James Cook and his crew became the first Europeans to chart the eastern coast of Australia, making landfall at Botany Bay and inspiring British interest in the area. In 1788, the First Fleet of convicts, led by Arthur Phillip, founded Sydney as a British penal colony, the first European settlement in Australia. Phillip named the city Sydney in recognition of Thomas Townshend, 1st Viscount Sydney. Penal transportation to New South Wales ended soon after Sydney was incorporated as a city in 1842. A gold rush occurred in the colony in 1851, and over the next century, Sydney transformed from a colonial outpost into a major global cultural and economic centre. After World War II, it experienced mass migration and became one of the most multicultural cities in the world. At the time of the 2011 census, more than 250 different languages were spoken in Sydney. In the 2016 Census, about 35.8% of residents spoke a language other than English at home. Furthermore, 45.4% of the population reported having been born overseas, making Sydney the 3rd largest foreign born population of any city in the world after London and New York City, respectively. Despite being one of the most expensive cities in the world, the 2018 Mercer Quality of Living Survey ranks Sydney tenth in the world in terms of quality of living, making it one of the most livable cities. It is classified as an Alpha+ World City by Globalization and World Cities Research Network, indicating its influence in the region and throughout the world. Ranked eleventh in the world for economic opportunity, Sydney has an advanced market economy with strengths in finance, manufacturing and tourism. There is a significant concentration of foreign banks and multinational corporations in Sydney and the city is promoted as Australia's financial capital and one of Asia Pacific's leading financial hubs. Established in 1850, the University of Sydney is Australia's first university and is regarded as one of the world's leading universities. Sydney is also home to the oldest library in Australia, State Library of New South Wales, opened in 1826. Sydney has hosted major international sporting events such as the 2000 Summer Olympics. The city is among the top fifteen most-visited cities in the world, with millions of tourists coming each year to see the city's landmarks. Boasting over 1,000,000 ha (2,500,000 acres) of nature reserves and parks, its notable natural features include Sydney Harbour, the Royal National Park, Royal Botanic Garden and Hyde Park, the oldest parkland in the country. Built attractions such as the Sydney Harbour Bridge and the World Heritage-listed Sydney Opera House are also well known to international visitors. The main passenger airport serving the metropolitan area is Kingsford-Smith Airport, one of the world's oldest continually operating airports. Established in 1906, Central station, the largest and busiest railway station in the state, is the main hub of the city's rail network.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(2));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Singapore
        c = new City();
        c.name = "Singapore";
        c.description = "Singapore (/ˈsɪŋ(ɡ)əpɔːr/), officially the Republic of Singapore, is an island city-state in Southeast Asia. It lies one degree (137 kilometres or 85 miles) north of the equator, at the southern tip of the Malay Peninsula, with Indonesia's Riau Islands to the south and Peninsular Malaysia to the north. Singapore's territory consists of one main island along with 62 other islets. Since independence, extensive land reclamation has increased its total size by 23% (130 square kilometres or 50 square miles). The country is known for its transition from a developing to a developed one in a single generation under the leadership of its founder Lee Kuan Yew. In 1819, Sir Stamford Raffles founded colonial Singapore as a trading post of the British East India Company. After the company's collapse in 1858, the islands were ceded to the British Raj as a crown colony. During the Second World War, Singapore was occupied by Japan. It gained independence from the British Empire in 1963 by joining Malaysia along with other former British territories (Sabah and Sarawak), but separated two years later over ideological differences, becoming a sovereign nation in 1965. After early years of turbulence and despite lacking natural resources and a hinterland, the nation developed rapidly as an Asian Tiger economy, based on external trade and its workforce. Singapore is a global hub for education, entertainment, finance, healthcare, human capital, innovation, logistics, manufacturing, technology, tourism, trade, and transport. The city ranks highly in numerous international rankings, and has been recognised as the most \"technology-ready\" nation (WEF), top International-meetings city (UIA), city with \"best investment potential\" (BERI), world's smartest city, world's safest country, second-most competitive country, third least-corrupt country, third-largest foreign exchange market, third-largest financial centre, third-largest oil refining and trading centre, fifth-most innovative country, and the second-busiest container port. The Economist has ranked Singapore as the most expensive city to live in, since 2013. It is identified as a tax haven. Singapore is the only country in Asia with an AAA sovereign rating from all major rating agencies, and one of 11 worldwide. Globally, the Port of Singapore and Changi Airport have held the titles of leading \"Maritime Capital\" and \"Best Airport\" respectively for consecutive years, while Singapore Airlines is the 2018 \"World's Best Airline\". Singapore ranks 9th on the UN Human Development Index with the 3rd highest GDP per capita. It is placed highly in key social indicators: education, healthcare, life expectancy, quality of life, personal safety and housing. Although income inequality is high, 90% of homes are owner-occupied. According to the Democracy Index, the country is described as a \"flawed democracy\". The city-state is home to 5.6 million residents, 39% of whom are foreign nationals, including permanent residents. There are four official languages: English, Malay, Mandarin Chinese, and Tamil; most Singaporeans are bilingual and English serves as the nation's lingua franca, while Malay is the national language. Its cultural diversity is reflected in its extensive ethnic cuisine and major festivals. Pew Research has found that Singapore has the highest religious diversity of any country. Multiracialism has been enshrined in its constitution since independence, and continues to shape national policies in education, housing, politics, among others. Singapore is a unitary parliamentary republic with a Westminster system of unicameral parliamentary government. The People's Action Party has won every election since self-government began in 1959. As one of the five founding members of ASEAN, Singapore is the host of the Asia-Pacific Economic Cooperation (APEC) Secretariat and Pacific Economic Cooperation Council (PECC) Secretariat, as well as many international conferences and events. It is also a member of the East Asia Summit, Non-Aligned Movement and the Commonwealth of Nations.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 3;
        c.temperature = 1;
        cityBox.put(c);

        //Shenzhen
        c = new City();
        c.name = "Shenzhen";
        c.description = "Shenzhen ([ʂə́n.ʈʂə̂n]) is a major city in Guangdong Province, China; it forms part of the Pearl River Delta megalopolis, bordering Hong Kong to the south, Huizhou to the northeast, and Dongguan to the northwest. It holds sub-provincial administrative status, with powers slightly less than those of a province. Shenzhen, which roughly follows the administrative boundaries of Bao'an County, officially became a city in 1979, taking its name from the former county town, whose train station was the last stop on the Mainland Chinese section of the railway between Canton and Kowloon. In 1980, Shenzhen was established as China's first special economic zone. Shenzhen's registered population as of 2017 was estimated at 12,905,000. However, the Shenzhen Municipal Party Committee estimates that the population of Shenzhen is about 20 million, due to the large unregistered floating migrant population living in the city. Shenzhen was one of the fastest-growing cities in the world in the 1990s and the 2000s and has been ranked second on the list of ‘top 10 cities to visit in 2019 by Lonely Planet. Shenzhen's cityscape results from its vibrant economy - made possible by rapid foreign investment following the institution of the policy of \"reform and opening-up\" in 1979. The city is a leading global technology hub, dubbed by media as the next Silicon Valley. Shenzhen hosts the Shenzhen Stock Exchange as well as the headquarters of numerous multinational companies such as JXD, Vanke, Hytera, CIMC, SF Express, Shenzhen Airlines, Nepstar, Hasee, Ping An Bank, Ping An Insurance, China Merchants Bank, Tencent, ZTE, Huawei, DJI and BYD. Shenzhen ranks 14th in the 2019 Global Financial Centres Index. It has one of the busiest container ports in the world.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 1;
        cityBox.put(c);

        //Delhi
        c = new City();
        c.name = "Delhi";
        c.description = "Delhi (/ˈdɛli/, Hindi pronunciation: [dɪlliː] Dillī, Punjabi pronunciation: [dɪlliː] Dillī, Urdu pronunciation: [dɛhliː] Dehlī), officially the National Capital Territory of Delhi (NCT), is a city and a union territory of India containing New Delhi, the capital of India. It is bordered by Haryana on three sides and by Uttar Pradesh to the east. The NCT covers an area of 1,484 square kilometres (573 sq mi). According to the 2011 census, Delhi's city proper population was over 11 million, the second-highest in India after Mumbai, while the whole NCT's population was about 16.8 million. Delhi's urban area is now considered to extend beyond the NCT boundaries and include the neighboring satellite cities of Faridabad, Gurgaon, Ghaziabad and Noida in an area now called Central National Capital Region (CNCR) and had an estimated 2016 population of over 26 million people, making it the world's second-largest urban area according to United Nations. As of 2016, recent estimates of the metro economy of its urban area have ranked Delhi either the most or second-most productive metro area of India. Delhi is the second-wealthiest city in India after Mumbai, with a total private wealth of $450 billion and is home to 18 billionaires and 23,000 millionaires. Delhi has been continuously inhabited since the 6th century BCE. Through most of its history, Delhi has served as a capital of various kingdoms and empires. It has been captured, ransacked and rebuilt several times, particularly during the medieval period, and modern Delhi is a cluster of a number of cities spread across the metropolitan region. A union territory, the political administration of the NCT of Delhi today more closely resembles that of a state of India, with its own legislature, high court and an executive council of ministers headed by a Chief Minister. New Delhi is jointly administered by the federal government of India and the local government of Delhi, and serves as the capital of the nation as well as the NCT of Delhi. Delhi hosted the first and ninth Asian Games in 1951 and 1982, respectively, 1983 NAM Summit, 2010 Men's Hockey World Cup, 2010 Commonwealth Games, 2012 BRICS Summit and was one of the major host cities of the 2011 Cricket World Cup. Delhi is also the centre of the National Capital Region (NCR), which is a unique 'interstate regional planning' area created by the National Capital Region Planning Board Act of 1985.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Mumbai
        c = new City();
        c.name = "Mumbai";
        c.description = "Mumbai (/mʊmˈbaɪ/, also known as Bombay /bɒmˈbeɪ/, the official name until 1995) is the capital city of the Indian state of Maharashtra. As of 2011 it is the most populous city in India with an estimated city proper population of 12.4 million. The larger Mumbai Metropolitan Region is the second most populous metropolitan area in India, with a population of 21.3 million as of 2016. Mumbai lies on the Konkan coast on the west coast of India and has a deep natural harbour. In 2008, Mumbai was named an alpha world city. It is also the wealthiest city in India, and has the highest number of millionaires and billionaires among all cities in India. Mumbai is home to three UNESCO World Heritage Sites: the Elephanta Caves, Chhatrapati Shivaji Maharaj Terminus, and the city's distinctive ensemble of Victorian and art Deco buildings. The seven islands that constitute Mumbai were originally home to communities of Koli people, who originated in Gujarat in prehistoric times. For centuries, the islands were under the control of successive indigenous empires before being ceded to the Portuguese Empire and subsequently to the East India Company when in 1661 Charles II of England married Catherine of Braganza and as part of her dowry Charles received the ports of Tangier and Seven Islands of Bombay. During the mid-18th century, Bombay was reshaped by the Hornby Vellard project, which undertook reclamation of the area between the seven islands from the sea. Along with construction of major roads and railways, the reclamation project, completed in 1845, transformed Bombay into a major seaport on the Arabian Sea. Bombay in the 19th century was characterised by economic and educational development. During the early 20th century it became a strong base for the Indian independence movement. Upon India's independence in 1947 the city was incorporated into Bombay State. In 1960, following the Samyukta Maharashtra Movement, a new state of Maharashtra was created with Bombay as the capital. Mumbai is the financial, commercial and entertainment capital of India. It is also one of the world's top ten centres of commerce in terms of global financial flow, generating 6.16% of India's GDP and accounting for 25% of industrial output, 70% of maritime trade in India (Mumbai Port Trust and JNPT), and 70% of capital transactions to India's economy. The city houses important financial institutions such as the Reserve Bank of India, the Bombay Stock Exchange, the National Stock Exchange of India, the SEBI and the corporate headquarters of numerous Indian companies and multinational corporations. It is also home to some of India's premier scientific and nuclear institutes like Bhabha Atomic Research Centre, Nuclear Power Corporation of India, Indian Rare Earths, Tata Institute of Fundamental Research, Atomic Energy Regulatory Board, Atomic Energy Commission of India, and the Department of Atomic Energy. The city also houses India's Hindi (Bollywood) and Marathi cinema industries. Mumbai's business opportunities, as well as its potential to offer a higher standard of living, attract migrants from all over India, making the city a melting pot of many communities and cultures.";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Kuala Lumpur
        c = new City();
        c.name = "Kuala Lumpur";
        c.description = "Kuala Lumpur (/ˈkwɑːlə ˈlʊmpʊər, -pər/; Malaysian: [ˈkwalə ˈlumpʊr]), officially the Federal Territory of Kuala Lumpur (Malay: Wilayah Persekutuan Kuala Lumpur), or commonly known as KL, is the national capital and largest city in Malaysia. As the global city of Malaysia, it covers an area of 243 km2 (94 sq mi) and has an estimated population of 1.73 million as of 2016. Greater Kuala Lumpur, also known as the Klang Valley, is an urban agglomeration of 7.25 million people as of 2017. It is among the fastest growing metropolitan regions in Southeast Asia, in both population and economic development. Kuala Lumpur is the cultural, financial, and economic centre of Malaysia. It is also home to the Parliament of Malaysia, and the official residence of the Malaysian King (Yang di-Pertuan Agong), the Istana Negara. The city once held the headquarters of the executive and judicial branches of the federal government, but these were relocated to Putrajaya in early 1999. However, some sections of the political bodies still remain in Kuala Lumpur. Kuala Lumpur is one of the three Federal Territories of Malaysia, enclaved within the state of Selangor, on the central west coast of Peninsular Malaysia. Since the 1990s, the city has played host to many international sporting, political, and cultural events including the 1998 Commonwealth Games and the 2017 Southeast Asian Games. Kuala Lumpur has undergone rapid development in recent decades, and is home to the tallest twin buildings in the world, the Petronas Towers, which have since become an iconic symbol of Malaysian development. Kuala Lumpur has a comprehensive road system supported by an extensive range of public transport networks, such as the Mass Rapid Transit (MRT), Light Metro (LRT), Bus Rapid Transit (BRT), monorail, commuter rail, and an airport rail link. Kuala Lumpur is one of the leading cities in the world for tourism and shopping, being the tenth most-visited city in the world in 2017. The city houses three of the world's ten largest shopping malls. Kuala Lumpur has been ranked by the Economist Intelligence Unit's Global Liveability Ranking at No. 70 in the world, and No. 2 in Southeast Asia after Singapore. EIU's Safe Cities Index of 2017 rated Kuala Lumpur 31st out of 60 on its world's safest cities list, safer than Beijing or Shanghai. Kuala Lumpur was named as one of the New7Wonders Cities, and has been named as World Book Capital 2020 by UNESCO.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 3;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Buenos Aires
        c = new City();
        c.name = "Buenos Aires";
        c.description = "Buenos Aires (/ˌbweɪnəs ˈɛəriːz/ or /-ˈaɪrɪs/; Spanish pronunciation: [ˈbwenos ˈaiɾes]) is the capital and largest city of Argentina. The city is located on the western shore of the estuary of the Río de la Plata, on the South American continent's southeastern coast. \"Buenos Aires\" can be translated as \"fair winds\" or \"good airs\", but the former was the meaning intended by the founders in the 16th century, by the use of the original name \"Real de Nuestra Señora Santa María del Buen Ayre\". The Greater Buenos Aires conurbation, which also includes several Buenos Aires Province districts, constitutes the fourth-most populous metropolitan area in the Americas, with a population of around 15.6 million. The city of Buenos Aires is neither part of Buenos Aires Province nor the Province's capital; rather, it is an autonomous district. In 1880, after decades of political infighting, Buenos Aires was federalized and removed from Buenos Aires Province. The city limits were enlarged to include the towns of Belgrano and Flores; both are now neighborhoods of the city. The 1994 constitutional amendment granted the city autonomy, hence its formal name: Autonomous City of Buenos Aires (Ciudad Autónoma de Buenos Aires; \"CABA\"). Its citizens first elected a chief of government (i.e. mayor) in 1996; previously, the mayor was directly appointed by the President of the Republic. Buenos Aires is considered an 'alpha city' by the study GaWC5. Buenos Aires' quality of life was ranked 91st in the world, being one of the best in Latin America in 2018. It is the most visited city in South America, and the second-most visited city of Latin America (behind Mexico City). Buenos Aires is a top tourist destination, and is known for its preserved Eclectic European architecture and rich cultural life. Buenos Aires held the 1st Pan American Games in 1951 as well as hosting two venues in the 1978 FIFA World Cup. Buenos Aires hosted the 2018 Summer Youth Olympics and the 2018 G20 summit. Buenos Aires is a multicultural city, being home to multiple ethnic and religious groups. Several languages are spoken in the city in addition to Spanish, contributing to its culture and the dialect spoken in the city and in some other parts of the country. This is because in the last 150 years the city, and the country in general, has been a major recipient of millions of immigrants from all over the world, making it a melting pot where several ethnic groups live together and being considered one of the most diverse cities of the Americas.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.tourists = 3;
        c.temperature = 2;
        cityBox.put(c);

        //Cordoba
        c = new City();
        c.name = "Cordoba";
        c.description = "Córdoba (Spanish pronunciation: [ˈkoɾðoβa]) is a city in the geographic center of Argentina, in the foothills of the Sierras Chicas on the Suquía River, about 700 km (435 mi) northwest of the Buenos Aires. It is the capital of Córdoba Province and the second most populous city in Argentina after Buenos Aires, with about 1,330,023 inhabitants according to the 2010 census. It was founded on 6 July 1573 by Jerónimo Luis de Cabrera, who named it after Córdoba, Spain. It was one of the first Spanish colonial capitals of the region that is now Argentina (the oldest city is Santiago del Estero, founded in 1553). The National University of Córdoba is the oldest university of the country and the seventh to be inaugurated in Spanish America. It was founded in 1613 by the Jesuit Order. Because of this, Córdoba earned the nickname La Docta (\"the learned\"). Córdoba has many historical monuments preserved from Spanish colonial rule, especially buildings of the Roman Catholic Church. The most recognizable is perhaps the Jesuit Block (Spanish: Manzana Jesuítica), declared in 2000 as a World Heritage Site by UNESCO which consists of a group of buildings dating from the 17th century, including the Colegio Nacional de Monserrat and the colonial university campus. The campus belongs today to the historical museum of the National University of Córdoba, which has been the second-largest university in the country since the early 20th century (after the University of Buenos Aires), in terms of the number of students, faculty, and academic programs. Córdoba is also known for its historical movements, such as Cordobazo and La Reforma del '18 (known as University Revolution in English).";
        c.kinds.add(kindManager.getKind(2));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 2;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(2));
        c.tourists = 2;
        c.temperature = 2;
        cityBox.put(c);

        //Havana
        c = new City();
        c.name = "Havana";
        c.description = "Havana (/həˈvænə/; Spanish: La Habana [la aˈβana]) is the capital city, largest city, province, major port, and leading commercial center of Cuba. The city has a population of 2.1 million inhabitants, and it spans a total of 781.58 km2 (301.77 sq mi) – making it the largest city by area, the most populous city, and the fourth largest metropolitan area in the Caribbean region. The city of Havana was founded by the Spanish in the 16th century and due to its strategic location it served as a springboard for the Spanish conquest of the Americas, becoming a stopping point for treasure-laden Spanish galleons returning to Spain. The King Philip II of Spain granted Havana the title of City in 1592. Walls as well as forts were built to protect the old city. The sinking of the U.S. battleship Maine in Havana's harbor in 1898 was the immediate cause of the Spanish–American War. The city is the center of the Cuban government, and home to various ministries, headquarters of businesses and over 90 diplomatic offices. The current mayor is Marta Hernández of the Communist Party of Cuba (PCC). In 2009, the city/province had the third highest income in the country. Contemporary Havana can essentially be described as three cities in one: Old Havana, Vedado and the newer suburban districts. The city extends mostly westward and southward from the bay, which is entered through a narrow inlet and which divides into three main harbors: Mari melena, Guanabacoa and Antares. The sluggish Almendares River traverses the city from south to north, entering the Straits of Florida a few miles west of the bay. The city attracts over a million tourists annually; the Official Census for Havana reports that in 2010 the city was visited by 1,176,627 international tourists, a 20% increase from 2005. Old Havana was declared a UNESCO World Heritage Site in 1982. The city is also noted for its history, culture, architecture and monuments. As typical of Cuba, Havana experiences a tropical climate.";
        c.kinds.add(kindManager.getKind(0));
        c.kinds.add(kindManager.getKind(3));
        c.kinds.add(kindManager.getKind(4));
        c.local = false;
        c.budget = 1;
        c.activities.add(attractionManager.getAttraction(0));
        c.activities.add(attractionManager.getAttraction(1));
        c.activities.add(attractionManager.getAttraction(3));
        c.tourists = 1;
        c.temperature = 2;
        cityBox.put(c);
    }

    public List<City> getRandomCities(){
        Random random = new Random();
        /*numero casuale di città*/
        int numberCities = random.nextInt(10) + 1;
        List<City> cities = new ArrayList<>();
        /*Usata per evitare ripetizioni sulle città scelte*/
        List<Integer> retrieved = new ArrayList<>();
        /*città scelte casualmente per id*/
        int cityId;
        int i = 0;
        while(i<numberCities){
            cityId = random.nextInt(54) + 1;
            if(!retrieved.contains(cityId)){
                /*se la città non è gia stata pescata, viene fatto ora*/
                retrieved.add(cityId);
                cities.add(cityBox.get(cityId));
                i++;
            }
        }
        return cities;
    }

    public List<City> getCity(int kind, int local, int budget, int activities, int tourist, int temperature) {
        List<City> cities = null;

        if(local == 2 && temperature == 3){
            cities = cityBox.query().equal(City_.budget, budget)
                    .and()
                    .greater(City_.tourists, tourist+1)
                    .build()
                    .find();
        }else if(local == 2){
            cities = cityBox.query().equal(City_.budget, budget)
                    .and()
                    .less(City_.tourists, tourist+1)
                    .and()
                    .equal(City_.temperature, temperature)
                    .build().find();
        }else if(temperature == 3){
            if(local == 0){
                cities = cityBox.query().equal(City_.local, false)
                        .and()
                        .less(City_.budget, budget+1)
                        .and()
                        .greater(City_.tourists, tourist+1)
                        .build().find();
            }else{
                cities = cityBox.query().equal(City_.local, true)
                        .and()
                        .less(City_.budget, budget+1)
                        .and()
                        .greater(City_.tourists, tourist+1)
                        .build().find();
            }
        }else{
            if(local == 0){
                cities = cityBox.query().equal(City_.local, false)
                        .and()
                        .less(City_.budget, budget+1)
                        .and()
                        .greater(City_.tourists, tourist+1)
                        .and()
                        .equal(City_.temperature, temperature)
                        .build().find();
            }else{
                cities = cityBox.query().equal(City_.local, true)
                        .and()
                        .less(City_.budget, budget+1)
                        .and()
                        .less(City_.tourists, tourist+1)
                        .and()
                        .equal(City_.temperature, temperature)
                        .build().find();
            }
        }

        return filter(kind, activities, cities);
    }

    private List<City> filter(int kind, int activities, List<City> cities){
        /*it filter the cities returned in base of the choices of the users*/
        Kind k = kindManager.getKind(kind);
        Attraction a = null;
        /*user may want to do all activities possible (aka 'activities' = 4)*/
        if(activities<4)
            a = attractionManager.getAttraction(activities);

        /*  get cities where city.kind has kind and city.activities has activities*/
        List<City> toBeReturned = new ArrayList<>();
        toBeReturned = baseStep(a,k,cities);

        if(toBeReturned.size()==0){
            //if the list is empty, is better if we are easier on the "kind" property
            if(kind==3) {
                //getting both "sea" and "mountain" as kind (there aren't cities with both of these)
                k = kindManager.getKind(0);
                toBeReturned = baseStep(a,k,cities);
                k = kindManager.getKind(1);
                toBeReturned.addAll(baseStep(a,k,cities));
            }
            else{
                if(kind==4) {
                    //getting "art" as kind
                    k = kindManager.getKind(2);
                }else if (kind==2){
                    //getting "romantic" as kind
                    k = kindManager.getKind(4);
                }
                toBeReturned = baseStep(a,k,cities);
            }
        }
        return toBeReturned;
    }

    private List<City> baseStep(Attraction a, Kind k, List<City> cities){
        List<City> toBeReturned = new ArrayList<>();
        if(a!=null) {
            for (City c : cities) {
                if (c.kinds.contains(k) && c.activities.contains(a))
                    toBeReturned.add(c);
            }
        }
        else{
            for (City c : cities) {
                if (c.kinds.contains(k))
                    toBeReturned.add(c);
            }
        }
        return toBeReturned;
    }

    public City getCity(String name){
        /*Ritorna la città associata al nome. Notare che non compie azioni di modifica
        * della stringa di ricerca.*/
        return cityBox.query().equal(City_.name, name).build().findFirst();
    }
}

