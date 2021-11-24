# Tutorial APAP
## Authors
* **Najla Laila Muharram** - *1906399612* - *C*

---
## Tutorial 7
**1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.** 

Latihan Nomor 1


![](https://i.ibb.co/FbtXQgc/nomor1.jpg)

Saya membuat function yang akan menghandle delete barang dari keranjang. Pada function tersebut saya mengambil semua barang yang ada di keranjang dan juga mengambil objek barang yang akan dihapus. Kemudian saya mengambil index dari barang yang akan dihapus dari existItems. Saya melakukan pengecekan validasi terlebih dahulu apakah barang dengan index tersebut tersedia di keranjang (jika tersedia maka nilainya akan lebih dari 0). Setelah memastikan jika barang tersebut ada di keranjang lalu mengubah status barang tersebut menjadi tidak dalam keranjang dengan menset boolean menjadi false. Kemudian menghapus item tersebut dari list barang dalam keranjang dengan menggunakan splice dan mengupdate kembali isi dari keranjang. 

![](https://i.ibb.co/PwvfXcT/nomor1lagi.jpg)

Setelah itu, saya menambahkan kode berikut. Sehingga, saat user menekan tombol hapus pada interface akan menjalankan function seperti yang saya jelaskan di atas. 

Latihan Nomor 2

![](https://i.ibb.co/LRHbbF8/nomor2.jpg)

Yang saya lakukan untuk soal latihan2 ini saya membuat dua function yaitu increaseBalance dan decreaseBalance. Inti dari function decreaseBalance yaitu mengurangi balance dengan harga dari barang yang di add ke keranjang, maka dari itu function ini dipanggil saat melakukan add barang ke keranjang yaitu setelah menambahkan suatu barang ke keranjang (Dapat dilihat pada gambar pertama). Sedangkan untuk function increaseBalance saya hanya menambahkan balance dengan harga barang yang baru dihapus dari keranjang, maka saya memanggil function ini setelah menghapus suatu barang dari keranjang. 

Nomor 3 

![](https://i.ibb.co/LRHbbF8/nomor2.jpg)

![](https://i.ibb.co/pQszYwf/nomor3.jpg)

Saya melakukan validasi sebelum user melakukan add barang ke dalam keranjang dengan terlebih dahulu mengecek apakah balance jika dikurangi dengan harga barang yang ingin ditambah masih lebih besar sama dengan nol, jika ia maka saya melanjutkannya dengan melakukan pengurangan balance dikurangi dengan harga barang kemudian mereturn true agar barang yang ingin tambahkan user masuk ke dalam keranjang. Sedangkan, jika balance dikurangi dengan harga barang memiliki nilai kurang dari nol, maka akan masuk ke bagian else maka akan menampilkan alert seperti yang diminta pada soal dan mereturn boolean false sehingga tidak akan dilakukan penambahan barang tersebut ke dalam keranjang. 

**2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?** 
Props merupakan singkatan dari property yang setara dengan argumen pada sebuah function di bahasa pemrograman seperti java atau python, props juga mirip dengan attribute pada tag HTML. Props digunakan untuk melakukan komunikasi data antar component dari parent component ke child component.Sifat dari props ini read-only dan tidak dapat dimodifikasi.

Sedangkan state adalah data private yang dimiliki component yang terus berubah sesuai dengan perilaku program. Data ini hanya tersedia untuk component tersebut dan tidak bisa di akses dari component lain.Berbeda dengan props yang valuenya dilempar dari component lain, state justru dapat menyimpan dan mengubah datanya sendiri dari dalam.

**3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.** 
Menurut saya sebaiknya kira menggunakan component karena component bersifat reusable. Contohnya adalah pada tutorial kali ini dimana ada component List dan Item yang bisa dipanggil ulang untuk menampilkan seluruh list yang ada di file json sekaligus menampilkan seluruh barang di chart. Kode ini bisa kita panggil berkali-kali sesuai denga kebutuhan kita. 

**4. Apa perbedaan class component dan functional component?** 
Functional components lebih ringkas struktur kodenya. Hal ini sangat efektif karena kita tidak perlu mengetik terlalu panjang. Namun, terdapat perbedaan yang cukup signifikan antara class component dan function component, yaitu **functional component** hanya bisa menggunakan props itu sebabnya function component disebut stateless component atau biasa digunakan juga sebagai UI Component (komponen yang menangani tampilan). Sedangkan Class component dapat menggunakan state dan props.

**5. Dalam react, apakah perbedaan component dan element?**
Elemen adalah blok bangunan terkecil di React, yang menggambarkan apa yang akan dilihat oleh user di layar mereka. Secara sederhana, elemen dapat didefinisikan sebagai representasi virtual dari DOM. Sedangkan, component pada React secara konsep sama seperti function pada JavaScript, perbedaannya adalah jika function menerima sebarang input yang disebut parameter atau argumen dan me-return sebuah nilai, component menerima input yang disebut props dan me-return React Element yang menggambarkan apa yang akan ditampilkan di layar. Component memungkinkan kita untuk membuat UI yang independent, isolated, dan reusable sehingga mengurangi repetisi kode.

Referensi :
https://id.reactjs.org/docs/hooks-state.html
https://hasanmubarok.medium.com/mengenal-element-components-dan-props-di-react-bbff544dd201

---
## Tutorial 6

**1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**

Otentikasi adalah verifikasi apakah seseorang itu adalah orang yang berhak.atau tidak untuk mengakses suatu fitur. Sedangkan,  otorisasi adalah pencarian apakah orang yang sudah diidentifikasi (sebelumnya sudah terlebih dahulu di otentifikasi), mempunyai akses untuk memanipulasi sumber daya tertentu.

Contoh otentikasi :

`@Autowired
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
}`

Contoh Otorisasi :
`http.authorizeRequests()
http.antMatchers("/css/**").permitAll()
http.antMatchers("/js/**").permitAll()
http.antMatchers("/user/viewall").hasAuthority("ADMIN")
http.antMatchers("/user/add").hasAuthority("ADMIN")
http.antMatchers("/user/delete").hasAuthority("ADMIN")
http.antMatchers("/penjaga/**").hasAuthority("MANAGER")`


**2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.**

BCryptPasswordEncoder merupakan salah satu fungsi password hashing. BCryptPasswordEncoder  melakukan encrypt terhadap password yang dimasukkan oleh user. Cara kerjanya BCryptPasswordEncoder adalah  dengan melakukan encrypt password setelah user melakukan  klik 'save' sehingga password yang terlihat pada database adalah password yang sudah dienkripsi.

**3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?**
   
Menurut saya penyimpanan password akan lebih aman jika dilakukan dengan hashing daripada encryption.Hal ini dikarenakan pada proses encryption password diubah menjadi pesan yang tidak mudah dibaca atau yang biasa dikenal dengan ciphertext.Ciphertext yang diperoleh dari encryption dapat dengan mudah diubah menjadi plaintext menggunakan encryption key.

**4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!**
   
UUID adalah kumpulan 32 karakter (String) yang dibuat secara acak (random) dengan teknik khusus yang dijamin unik untuk setiap data. Kegunaan UUID adalah sebagai primary key dari model tersebut. UUID digunakan untuk memungkinkan sistem mengenerate id pengguna secara unik dengan hashing sebanyak 32 karakter secara acak yang bertujuan untuk meningkatkan keamanan data pengguna sehingga id pengguna aman dan tidak mudah untuk diretas. Mirip seperti BCrypt, bedanya kali ini adalah ID, bukan password. Saat kita membuat user baru, sistem akan otomatis melakukan pemberian kode unik yang akan terlihat pada database dengan tipe UUID.

Pada tutorial ini, UUID digunakan di UserModel.java:
`@Id
@GeneratedValue(generator = "system-uuid")
@GenericGenerator(name="system-uuid", strategy = "uuid")
private String id;
`

**5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?**

UserDetailsServiceImpl.java berbeda dengan UserRoleServiceImpl.java. UserDetailsServiceImpl.java memiliki fungsi untuk melakukan implements interface. Sedangkan, UserDetailsService sudah digenerate oleh springboot untuk digunakan dalam mendapatkan user-related data. Class UserDetailsServiceImpl.java mengimplementasi interface UserDetailService yang sudah disediakan oleh spring security. Class tersebut berguna untuk mengambil informasi otentikasi dan otorisasi pengguna. Tujuannya agar Spring Boot Security dapat melakukan otorisasi terhadap pengguna yang melakukan login sesuai dengan rolenya yang sudah terdaftar di database. Class ini harus ada karena class UserServiceImpl dan RoleServiceImpl tidak dapat memberikan informasi kepada Spring boot mengenai otentikasi dan otorisasi dari akun-akun yang ada pada database sistem.

Sumber :
https://www.yiiframework.com/doc/guide/1.1/id/topics.auth
https://id-laravel.com/post/menggunakan-uuid-di-php-laravel/

---
## Tutorial 5
**1. Apa itu Postman? Apa kegunaannya?**

Postman adalah sebuah aplikasi yang berfungsi sebagai REST CLIENT untuk uji coba REST API. Postman biasanya digunakan untuk melakukan build, test, dan modify API. Postman biasa digunakan oleh developer pembuat API sebagai tools untuk menguji API yang telah mereka buat. Dengan Postman, kita sebagai developer dapat mendokumentasikan, tes, mendesain, melakukan debug, menerbitkan, dan memonitor API pada satu tempat. Developer tidak harus menulis HTTP client network code, tetapi membuat test suites yang dinamakan "Collections" ketika menggunakan Postman untuk melakukan testing. Postman akan berinteraksi dengan API secara otomatis.

**2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.**

@JsonIgnoreProperties berfungsi untuk memberikan perintah pada class untuk mengabaikan properti logis yang ditentukan dalam serialisasi dan deserialisasi JSON. Dengan begitu jika suatu saat ada field baru yang dimasukkan di JSON yang merepresentasikan Model kita, maka JSON tidak akan throw UnrecognizedPropertyException saat parsing JSON di Java. Sebagai contoh, ketika kita memberikan true untuk element ignoreUnknown, maka field JSON akan diabaikan jika data JSON memiliki field yang tidak mempunyai properti logis.

@JsonProperty merupakan anotasi yang memiliki fungsi untuk mengubah nama variabel. @JsonProperty memberitahu Jackson ObjectMapper untuk memetakan nama property JSON ke nama bidang Java yang diberikan anotasi. @JsonProperty diartikan sebagai logical property yang digunakan di serialization dan deserialization di JSON. saat kita melakukan set JSON data pada Java Object, akan disebut JSON deseralization dan saat kita melakukan get JSON data dari Java Object, disebut JSON serialization. @JsonProperty dapat mengubah visibility dari logical property menggunakan access element saat serialization dan deseralization.


**3. Apa kegunaan atribut WebClient?**
   
1WebClient berfungsi untuk menginstansiasi sebuah akses poin URL serta mengelola request dan response atas URL tersebut. Selain itu, WebClient juga berfungsi sebagai poin akses utama dari web / HTTP requests.

**4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**
   **ResponseEntity** merepresentasikan keseluruhan HTTP response yaitu status code, headers, dan body. Sebagai hasilnya, kita dapat menggunakannya untuk mengkonfigurasi secara lengkap HTTP response. 

**BindingResult** biasanya berisikan informasi mengenai kesalahan, misalkan field yang diperlukan, adanya ketidakcocokan jenis atau kesalahan dalam melakukan pemanggilan method. BindingResult harus muncul tepat setelah objek model yang divalidasi atau Spring akan gagal untuk memvalidasi objek dan mengeluarkan Exception. Dengan kata lain Binding result digunakan sebagai argumen untuk metode validasi dari Validator di dalam Controller.


Sumber:
https://antares.id/id/postman.html#:~:text=Postman%20adalah%20sebuah%20aplikasi%20yang,API%20yang%20telah%20mereka%20buat.
https://medium.com/@novancimol12/postman-4f181d625fe1

Jackson Annotations - @JsonIgnoreProperties (tutorialspoint.com)

WebClient Class (System.Net) | Microsoft Docs

How to ignore unknown properties while parsing JSON in Java - Jackson @JsonIgnoreProperties Annotation Example - Java Code Geeks - 2021

Using Spring ResponseEntity to Manipulate the HTTP Response | Baeldung



---
## Tutorial 4
**1. Jelaskan perbedaan th:include dan th:replace!**

**th:include** akan memasukkan spesifik fragment sebagai body dari host tag nya namun tidak termasuk fragment tag nya.  Ini juga akan menyisipkan fragmen yang ditentukan sebagai body dari tag hostnya tetapi mengecualikan tag fragmen.

**th:replace** akan menghapus dan menggantikan host tag dengan konten fragment yang spesifik termasuk fragment tagnya. Dengan kata lain, ini akan menghapus host tag  dan sebagai gantinya host tag itu akan menambahkan fragmen yang ditentukan termasuk tag fragmen.


**2. Jelaskan apa fungsi dari th:object!**
th:object digunakan untuk menspesifikan object yang dibuat saat submit form.
Value dari th:object harus spesifik hanya nama dari model attribute yang dimaksud. Seperti  contohnya hanya bisa ${bioskop} bukan ${bioskop.listFilm}.
Jika pada form sudah dispesifikan pada satu objek maka tidak ada th:object lain
yang dapat dispesifikkan. Ini mengartikan bahwa HTML form tidak dapat iteratif. Dengan kata lain, th:object mereferensikan Model yang akan merepresentasikan state dari form yang dibuat.


**3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**

*= akan mengevaluasi atribut atau variabel dari th:object yang sudah di deklarasi sebelumnya. Merujuk pada data yang berada pada object yang sudah didefinisikan sebelumnya pada th:object.

$= akan mengevaluasi keseluruhan atribut atau variabel pada th:object digunakan saat ingin merujuk pada objek yang didapat dari model.addAttribute pada Controller.


Referensi :
-[difference-between-thymeleaf-attribute](https://anshulgnit.blogspot.com/2018/05/differencebetween-thymeleaf-attribute-replace-insert-and-include.html)
- [thymeleaf-fragments](https://attacomsian.com/blog/thymeleaf-fragments)
- [Baeldug - thymeleaf-in-spring-mvc](https://www.baeldung.com/thymeleaf-in-spring-mvc)



---
## Tutorial 3
1.Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
   (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
   
**@AllArgsConstructor** akan men-generate constructor yang memiliki hanya satu parameter untuk setiap field di kelas tersebut. Sedangkan
**@NoArgsConstructor** akan men-generate constructor tanpa parameter untuk setiap field di kelas tersebut. **@Setter** merupakan anotasi yang memungkinkan lombok untuk secara otomatis men-generate setter. Sama hal nya dengan **@Getter** yang memungkinkan lombok untuk secara otomatis men-generate getter. Sedangkan untuk **@Entity** merupakan anotasi yang menandakan bahwa class tersebut adalah JPA entity dan telah di-map ke tabel database. Yang terakhir **@Table** anotasi ini menspesifikasikan nama tabel database yang digunakan untuk mapping.

2.Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method
   tersebut?

   Method **findByNoBioskop** digunakan untuk mengembalikan objek bioskop berdasarkan noBioskop yang dijadikan sebagai parameter.

3.Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
  
 **@JoinTable** menyimpan id dari kedua tabel menjadi tabel yang terpisah. Sedangkan **@JoinColumn** menyimpan id dari tabel lain di sebuah kolom yang baru.
 **@JoinTable** cocok digunakan untuk mapping relationship many-to-many sehingga dapat meminimalisir kemungkinan redundansi data. **@JoinColumn** dapat membantu mewujudkan kinerja yang lebih baik dan efisien karena tidak perlu menggabungkan tabel tambahan.

4.Pada class PenjagaModel, digunakan anotasi **@JoinColumn** pada atribut bioskop, apa
   kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull
**Name** digunakan untuk menentukan foreign key column sedangkan **referencedColumnName**  digunakan untuk menentukan nama kolom dalam tabel yang dijadikan referensi oleh foreign key column.  **@Nullable**  digunakan untuk mendeklarasikan bahwa parameter beranotasi atau return value dapat menjadi null dalam beberapa keadaan.
Perbedaan antara **@NotNull** dengan **nullable** adalah **@NotNull** mendeklarasi seacara eksplisit bahwa metode tidak boleh mengembalikan nilai null dan field yang memiliki anotasi @NotNull tidak boleh bernilai null berbeda dengan **@Nullable** yang menyatakan jika method tersebut bisa saja mereturn nilai null.

5.Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

**FetchType.LAZY** hanya me-load attribute-attribute yang yang dibutuhkan. Berbeda dengan **FetchType.EAGER** yang akan meload attribute-attribute tersebut di waktu yang bersamaan.
**CascadeType.ALL** akan menyediakan properti cascase pada hubungan-hubungan sehingga ketika  melakukan operasi update dan delete, maka entitas lain yang berelasi dengan entitas tersebut akan ikut berubah.

Referensi :
https://www.baeldung.com/jpa-join-column
https://projectlombok.org/features/GetterSetter
https://projectlombok.org/features/constructor
https://www.objectdb.com/api/java/jpa/JoinColumn/referencedColumnName
https://www.baeldung.com/hibernate-lazy-eager-loading

---
## Tutorial 2

**Pertanyaan 1: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Terjadi error Whitelabel Error Page dengan status 500 karena belum ada template yang dituju yaitu add-bioskop.html
![](https://i.ibb.co/bX3SVJW/image.png)

**Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat**

Anotasi @Autowired pada kelas Controller adalah implementasi dari konsep depedency injection. Dengan menggunakan 
@Autowired memungkinkan kita memasukkan depedensi objek secara implisit, sehingga tidak perlu membuat
setter, getter, atau constructor.

**Pertanyaan 3: Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**
Terjadi error Whitelabel Error Page dengan status 400 karena link yang dimasukkan tidak lengkap. Alamat tersebut tidak mencantumkan jumlahStudio. 
![](https://i.ibb.co/JFK2m7v/image.png)

**Pertanyaan 4: Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?**

Pertama saya melakukan add bioskop maung dengan idBioskop 4:
http://localhost:8080/bioskop/add?idBioskop=4&namaBioskop=Bioskop%20MAUNG&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10
![](https://i.ibb.co/02czvtX/image.png)
Setelah itu saya mengakses http://localhost:8080/bioskop/view?idBioskop=4 untuk menampilkan detail dari Bioskop Maung 
![](https://i.ibb.co/R0GVrWP/image.png)


**Pertanyaan 5: Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**

Saya menambahkan Bioskop XXXI dengan id 8 
Setelah melakukan view all melalui http://localhost:8080/bioskop/viewall berikut merupakan tampilan yang muncul. Terdapat Bioskop dengan id 1, bioskop dengan id 4, dan bioskop dengan id 8.
![](https://i.ibb.co/ZfYbpkz/tut2apap.jpg)
![](https://i.ibb.co/fMj2Zwz/tut2apaplagi.jpg)

---
## Tutorial 1
### What I have learned today
Saya belajar kembali mengenai penggunaan framework springboot.

### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
Issue Tracker merupakan tracking tools yang yang terintegrasi dengan repositori GitHub.
Issue Tracker ini mendokumentasikan issue yang ada pada proyek kita secara terurut waktu.
Hal ini memudahkan proses tracking terhadap proyek-proyek yang  sedang berjalan.
Issue Tracker juga mengakomodasikan fitur mention. Saat kita melakukan mention issue pada issue
lain atau pada saat pull request maka otomatis akan muncul di timeline issue yang dimention.
Dengan ini  maka kita dapat dengan mudah melihat keterkaitannya. Maka Issue Tracker merupakan
cara yang bagus untuk melacak tasks, enhancements, and bugs pada proyek.

**2. Apa perbedaan dari git merge dan git merge --squash?**
Keduanya memiliki tujuan yaitu untuk menggabungkan commit-commit dari branch. Untuk Git merge squash melakukan penggabungan di Git yang akan menghasilkan commit gabungan dengan hanya satu parents. File digabungkan sama seperti halnya Git merge biasa  tetapi metadata commit diubah untuk menampilkan hanya satu commit parents.


**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?**
Dengan menggunakan VCS maka pengguna dapat mengembalikan berkas-berkas pekerjaan ke keadaan sebelumnya. Selain itu, dengan VCS pengguna dapat membandingkan suatu perubahan dengan perubahan-perubahan sebelumnya setiap waktu. Pada VCS juga pengguna dapat melihat siapa yang terakhir melakukan pengubahan terhadap sesuatu yang mungkin menimbulkan masalah. Selain itu, VCS juga memungkinkan developer untuk memiliki branch kode yang independent dan massive. Membuat, menghapus dan menggabungkan branch tersebut menjadi lebih cepat, lancar dan tidak butuh waktu yang lama.

### Spring
**4. Apa itu library & dependency?**
Library merupakan bagian tertentu dari perangkat lunak yang dapat dikonsumsi oleh program lain. Sedangkan dependency merupakan hubungan antara dua bagian kode. Seperti contohnya kode pertama memanggil kode kedua untuk melakukan tindakan atau mengembalikan beberapa informasi itu merupakan suatu bentuk dari dependency. Hubungan keduanya seperti hubungan orang dan kerabat.

**5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
Maven merupakan perangkat lunak manajemen proyek dan alat pemahaman. Berdasarkan konsep model objek proyek (POM), Maven dapat mengelola pembuatan, pelaporan, dan dokumentasi proyek dari informasi utama. Maven dikembangkan oleh Apache Software Foundation dan tipe lisensinya adalah free software license.
Maven ditulis dalam bahasa pemrograman Java dan pada awal masa pembuatannya dikenal sebagai Jakarta Project. Maven adalah tool yang menemani programmer
dari awal hingga akhir proses pengembangan. Hal ini dikarenakan Maven sangat berguna bagi programmer Java di dalam proses pengembangan aplikasi mulai dari pembuatan project, mereferensi external library (file-file JAR), pembuatan dokumentasi hingga compiling dan pembuatan application package (misalnya JAR atau WAR). Alasan kita menggunakan maven yaitu karena maven mempermudah pengerjaan. Alternatif lain selain Maven ada Gradle, Eclipse, dan Apache Ant.

**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?**
Spring framework dapat digunakan untuk mengembangkan aplikasi java lainnya baik mobile app, web app, dan desktop apps.

**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?**
Perbedaan paling penting dari @RequestParam dan @PathVariable terletak dari cara mengekstrak value. @PathVariable digunakan untuk mengakses nilai dari template URI. Sedangkan @RequestParam digunakan untuk mengakses nilai dari parameter query.

### What I did not understand
- [ ] Kenapa saya harus belajar APAP?
- [ ] Penggunaan @RequestParam @PathVariable
- [ ] Tidak mengerti package yang diimport di controller





