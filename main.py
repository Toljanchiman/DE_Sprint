#Автор: Анатолий Федорович З.
#1. Необходимо спарсить данные о вакансиях python разработчиков с сайта hh.ru



#2 Палиндром строки
value = "taco cat"
s = value.replace(' ', '').lower()
if (s==s[::-1]):
  print("True")
else:
  print("False")


#3 Перевод арабского числа в римское
coding = zip([1000,900,500,400,100,90,50,40,10,9,5,4,1],["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"])
num = 1945
if num <= 1 or num >= 2000 or int(num) != num:
    raise ValueError('Input between 1 and 2000')
result = []
for d, r in coding:
    while num >= d:
        result.append(r)
        num -= d
print(''.join(result))


#4. Валидность скобок
x = "[{}({})]"
a = '['
b = ']'
c = '('
d = ')'
e = '{'
f = '}'
if ((a in x) and (c in x) and (e in x)):
  if ((x.count(a) == x.count(b)) and (x.count(c) == x.count(d)) and (x.count(e) == x.count(f))):
    print("True1")
  else:
    print("False")
else:    
    if ((a in x) and (c in x)):
      if ((x.count(a) == x.count(b)) and (x.count(c) == x.count(d))):
        print("True2")
      else:
        print("False")
    else:    
        if (a in x):
          if (x.count(a) == x.count(b)):
            print("True3")
          else:
            print("False")
        else:
          print("False")
  
  
#5. Умножить два бинарных числа в формате строк
x1 = "111"
x2 = "101"
print(f"res = {(int(x1,2)*int(x2,2)):0b}")
