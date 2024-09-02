import requests
from bs4 import BeautifulSoup
import pandas as pd

def crawl_drama(keyword):
    keyword = "%20".join(keyword.split(" "))
    url = f'https://www.imdb.com/search/title/?title={keyword}&title_type=tv_series'
    
    hdr = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36',
        'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
        'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3',
        'Accept-Encoding': 'none',
        'Connection': 'keep-alive'
    }
    # 세션 객체 생성
    with requests.Session() as session:

        image_url = ""
        session.headers.update(hdr)
        response = session.get(url)
        try: 
            response.raise_for_status() # 요청이 성공했는지 확인
        except:
            print(keyword)
            return 0,0
        # BeautifulSoup 객체 생성
        soup = BeautifulSoup(response.text, 'html.parser')

        # 이미지 src 추출
        img_tags = soup.find_all('img')
        img_srcs = [img['src'] for img in img_tags if 'src' in img.attrs if '.jpg' in img['src']]
        # h3 요소 추출
        hangul_txts = soup.find_all('h3')

        hangul_txt = [h.get_text() for h in hangul_txts][0]

        # 결과 출력
        if not img_srcs: return 0,0
        image_url =img_srcs[0]
        
        return image_url, hangul_txt

if __name__ == "__main__":
    drama_df = pd.read_csv("./kdrama.csv")

    drama_df["korean_title"] = ""
    drama_df["image_url"] = ""
    
    image_url_list = []
    hangul_title_list = []
    for idx, title in enumerate(drama_df["title"]):
        img, hangul = crawl_drama(title)
        if img == 0 or hangul == 0: continue
        hangul = hangul.split(" ")[1:]
        drama_df.at[idx, "image_url"] = img
        drama_df.at[idx, "korean_title"] = hangul

    drama_df.to_csv("tmpdrama.csv", index=False, encoding="utf-8-sig")