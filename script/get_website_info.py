import requests
from bs4 import BeautifulSoup
from urllib.parse import urlparse, urljoin
import sys


# 获取网站的标题
def get_title(url):
    try:
        response = requests.get(url, timeout=5)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        title = soup.title
        if title:
            title = title.string
        return title
    except Exception as e:
        return None


# 查找网站logo图片链接
def get_logo_url(url):
    try:
        response = requests.get(url, timeout=5)
        response.raise_for_status()
        soup = BeautifulSoup(response.text, 'html.parser')
        logo = soup.find('img', {'src': True})
        if logo:
            logo_url = logo['src']
            # 判断logo_url是否是一个有效URL
            parsed_url = urlparse(logo_url)
            if not parsed_url.scheme:
                # 如果没有协议前缀，添加http前缀
                logo_url = urljoin(url, logo_url)
            # 确保logo_url是一个有效URL
            if not parsed_url.netloc:
                logo_url = '未找到Logo'
        else:
            logo_url = '未找到Logo'
        return logo_url
    except Exception as e:
        return None


if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("用法: python get_website_info.py <URL>")
        sys.exit(1)

    url = sys.argv[1]

    title = get_title(url)
    logo_url = get_logo_url(url)

    print('网站标题:', title)
    print('网站Logo链接:', logo_url)
