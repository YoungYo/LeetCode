<p>You are given an array of strings <code>equations</code> that represent relationships between variables where each string <code>equations[i]</code> is of length <code>4</code> and takes one of two different forms: <code>&quot;x<sub>i</sub>==y<sub>i</sub>&quot;</code> or <code>&quot;x<sub>i</sub>!=y<sub>i</sub>&quot;</code>.Here, <code>x<sub>i</sub></code> and <code>y<sub>i</sub></code> are lowercase letters (not necessarily different) that represent one-letter variable names.</p>

<p>Return <code>true</code><em> if it is possible to assign integers to variable names so as to satisfy all the given equations, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> equations = [&quot;a==b&quot;,&quot;b!=a&quot;]
<strong>Output:</strong> false
<strong>Explanation:</strong> If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
There is no way to assign the variables to satisfy both equations.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> equations = [&quot;b==a&quot;,&quot;a==b&quot;]
<strong>Output:</strong> true
<strong>Explanation:</strong> We could assign a = 1 and b = 1 to satisfy both equations.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> equations = [&quot;a==b&quot;,&quot;b==c&quot;,&quot;a==c&quot;]
<strong>Output:</strong> true
</pre>

<p><strong>Example 4:</strong></p>

<pre>
<strong>Input:</strong> equations = [&quot;a==b&quot;,&quot;b!=c&quot;,&quot;c==a&quot;]
<strong>Output:</strong> false
</pre>

<p><strong>Example 5:</strong></p>

<pre>
<strong>Input:</strong> equations = [&quot;c==c&quot;,&quot;b==d&quot;,&quot;x!=z&quot;]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= equations.length &lt;= 500</code></li>
	<li><code>equations[i].length == 4</code></li>
	<li><code>equations[i][0]</code> is a lowercase letter.</li>
	<li><code>equations[i][1]</code> is either <code>&#39;=&#39;</code> or <code>&#39;!&#39;</code>.</li>
	<li><code>equations[i][2]</code> is <code>&#39;=&#39;</code>.</li>
	<li><code>equations[i][3]</code> is a lowercase letter.</li>
</ul>
<div><div>Related Topics</div><div><li>Array</li><li>String</li><li>Union Find</li><li>Graph</li></div></div><br><div><li>👍 1042</li><li>👎 10</li></div>