a = 9101273416; b = 9101273416;

s = 0
olds = 1
t = 1
oldt = 0
r = b
oldr = a

while r != 0:
    quotient = oldr // r
    (oldr, r) = (r, oldr - quotient *r)
    (olds, s) = (s, olds - quotient *s)
    (oldt, t) = (t, oldt - quotient *t)       

print 'Bezout coefficients:', (olds, oldt)
print 'greatest common divisor:', oldr
print 'quotients by the gcd:' , (t, s)
u1 = oldt * a
u2 = olds * b
print 'U1 : ', u1, ' U2: ', u2
plzbeone = u1+u2
print 'u1 + u2 = ',plzbeone
a1 = 123456789
a2 = 987654321
x = a1*u1 + a2*u2
print 'x = ', x
print 'a_1 mod p_1 = ', (a1%a)
print 'a_2 mod p_2 = ', (a2%b)
print 'x mod p_1 = ', (x%a)
print 'x mod p_2 = ', (x%b)



