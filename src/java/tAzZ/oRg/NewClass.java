/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tAzZ.oRg;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author n1sh1kanT
 */
public class NewClass {

    public static void main(String[] args) throws Exception
    {
        FileInputStream in=new FileInputStream("C:/asdwwwf.jpg");
        byte[] data=new byte[(int)new File("C:/asdwwwf.jpg").length()];
        in.read(data);
        String s=new String(data);
        data=Base64.decode(s);
        new FileOutputStream("C:/lll.jpg").write(data);
    }
}
/*
 I know you want it
But you never gonna get it
Tere haath kabhi na aani
Maane na maane koi duniya
Yeh saari, mere ishq ki hai deewani

Hey hey,
I know you want it but you never gonna get it
Tere haath kabhi na aani
Maane na maane koi duniya yeh saari
Mere ishq ki hai deewani
Ab dil karta hai haule haule se
Main toh khud ko gale lagaun
Kisi aur ki mujhko zaroorat kya
Main toh khud se pyaar jataun

what's my name
what's my name
what's my name
My name is Sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani
Na na na sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani

Take it on
Take it on
Take it on
Take it on

Silly silly silly silly boys
O o o you're so silly
Mujhe bolo bolo karte hain
O o o
Haan jab unki taraf dekhun, baatein haule haule karte hain
Hai magar, beasar mujh par har paintra

Haye re aise tarse humko
Ho gaye sober se re
Sookhey dil pe megapan ke teri nazariya barse re
I know you want it but you never gonna get it
Tere haath kabhi na aani
Sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani
Na na na sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani

Paisa gaadi mehnga ghar
?ani na mainu ki gimme your that
Jaibein khaali bhadti chal
No no I don't lie like that

Chal yahan se nikal tujhe sab laa dunga
Kadmon mein tere laake jag rakh dunga
Khwaab main kar dunga poore
Na rahenge adhoore
You know I'm going to love you like that, whatever

Haye re aise tarse humko
Ho gaye sober se re
Sookhey dil pe begapan ke teri nazariya barse re
I know you want it but you never gonna get it
You never gonna get my body
I know you want it but you never gonna get it
Tere haath kabhi na aani
Maane na maane koi duniya yeh saari
Tere ishq ki main deewani

Ab dil karta hai haule haule se
Main toh khud ko gale lagaun
Kisi aur ki mujhko zaroorat kya
Main toh khud se pyaar jataun

What's my name
What's my name
What's my name

My name is Sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani
O no no sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani
Sheela
Sheela ki jawani
I'm just sexy for you
Main tere haath na aani

Ain't nobody got body like sheela
Everybody want body like sheela
Drive me crazy coz my name is sheela
Ain't nobody got body like sheela
Everybody want body like sheela
Drive me crazy coz my name is sheela
Ain't nobody got body like sheela 
 */