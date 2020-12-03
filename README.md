# SCLikesScraper
This program reads in a Soundcloud likes page, strips out each URL which leads to a song, and saves it to a text file named report.txt. This file contains one URL on each line, which allows it to be easily used with the yt-dl "batch download from file" function.

## Installation
> git clone https://github.com/dassit-sys/SCLikesScraper.git  

## Usage
1. Using your browser, navigate to your Soundcloud likes page. Next, you need to load up all your likes so that they are all fully displaying, and there is no more "scroll down for more" loading circle at the bottom. To make this faster, use the scroll wheel as shown in the following gif: ![](https://github.com/dassit-sys/SCLikesScraper/blob/main/2020-11-24%2013-35-18.gif?raw=true)
2. Now that the entire list is visible, we need to save the whole page. Right click on an empty part of the page and select "Save as...". For Chrome users, this may read "Save Page As...", and for Firefox users it may read "Save Page As".
3. Save the page in the same directory that this program is installed. Save as .html
4. Open Command Prompt, navigate to installation directory
5. Run:  
> java -jar Driver ***pageName.html***  
  
Obviously replace pageName.html with the filename of the page you saved in step 2  
6. Song URLs should be saved one-per-line in report.txt
7. prettyReport.txt holds "Artist name - Song title" one-per-line for other uses
8. (Optional) To download the songs, use with yt-dl. If you're on command line only, run:  
> youtube-dl -f best -a ***C:\... filepath ...\report.txt***  
  
Replace filepath with your report.txt's actual filepath.
Alternatively, if you use yt-dl GUI, click the arrow next to "download" and select "Batch download from file..." and select your report.txt file.
Enjoy!

## About The Project
Having accumulated over 700 likes on my Soundcloud account, I was looking for a way to save them locally in case Soundcloud ever went under, or in case I ever get my third copyright strike. However, Soundcloud does not have a "export" function. So, I made one. This project has been around for over a year, but only recently had I thought that others might find it useful also.

Everytime Soundcloud changes the formatting on their likes page, this tool may need updating. It has happened only once so far, and as of 11/24/2020 this program is still functional. If it needs updating feel free to contact me and let me know

## Built With
SCLikesScraper is built entirely in native Java.

## Contact
For anything related to this project you may contact elijaheason@ymail.com

## License
Distributed under the MIT License. See 'LICENSE' for more information
