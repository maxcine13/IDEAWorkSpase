# -*- coding:utf-8 -*-
import myUtil.dbutil as database
import myUtil.htmlUtil as html
import myUtil.fileutil as file
import sys

reload(sys)
# sys.setdefaultencoding('gb2312')
# http://www.71hy.com/com-8111355.html
# num = 0
# i = num * 10000
# ii = (num + 1) * 10000
# nums = file.readfileString('id_log_1.txt')
# if nums is not None:
#     i = int(nums)
#     print i
# else:
#     i = 5721
# for x in range(i, ii):
#     url = 'http://www.71hy.com/com-2057089.html'
#     soup = html.getHtmlSoup(url)
#     lefb = soup.find('div',{'class':'leftbox'})
#     title = lefb.find('h1').string
#     print title
#     content = lefb.find('div',{'id':'content'})
#     # print content
#     tradic = content.find_all('b')[2].string
#     for li in content.find_all('li'):
#         print li.string
#     break
import re

key = '<span class="key1">\
				挤塑板设备 珍珠棉设备 塑料格栅设备 塑料管材设备 pe木塑设备 石塑设备  <a href="sellmarket/pro653936">查看产品</a></span>'  # 这段是你要匹配的文本
p1 = r'(?<=<span class="key1">).+?(?=<a)'  # 这是我们写的正则表达式规则，你现在可以不理解啥意思
pattern1 = re.compile(p1)  # 我们在编译这段正则表达式
matcher1 = re.search(pattern1, key)  # 在源文本中搜索符合正则表达式的部分
print matcher1.group(0).strip()  # 打印出来
