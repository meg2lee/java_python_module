import pandas as pd
import matplotlib.pyplot as plt
import sys

#piechart를 만들어 저장하는 함수
def pieChart(imgfilename):
	labels=[frogs,hogs,dogs,logs]
	sizes=[15,40,30,20]
	explode=(0,0.1,0,0)
	figl,axl=plt.subplots()
	axl.pie(sizes,explode=explode,autopct='%1.1f%%',shadow=True,startangle=90)
	axl.axis('equal')

	plt.savefig(imgfilename) #생성된 piechart를 argument로 전달받은 경로에 저장
	plt.close()
	print("파이차트 완료")

def main(argv): 
	print("argv : " + argv[2])
	pieChart(argv[2]) #imgpath: 이미지저장경로를 pieChart함수에 argument로 전달

# __name__은 module 이름이 저장되는 변수이며, 해당 변수의 값이 '__main__'인 경우에만 하위 코드 실행
# 즉, 해당 파일이 메인 프로그램으로서 프로그램 시작점인지를 판단
if __name__=='__main__':
	main(sys.argv)
