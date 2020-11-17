# Card Queue GUI 


<h3><u>Objective</u></h3>
<p>This project summarizes the concepts of inheritance  learned from previous modules where we constructed base classes, <strong>StackNode</strong> and <strong>Stack,</strong> and derived&nbsp; <strong>FloatNode</strong> and <strong>FloatStack</strong> from them.&nbsp; The end goal is to write a client that shows a single <strong>DEQueue</strong> acting at times like a <strong>Stack</strong>, at other times like a <strong>Queue</strong>.&nbsp; This functionality was demonstrated by randomly adding and removing from both sides of the <strong>DEQueue</strong>.</p>
<ol>
<li>Instead of the previously implemented <strong>Stack</strong> data structure, a <strong>Queue</strong> data structure was created.&nbsp; A <strong>Stack</strong> is <i><strong>last-in-first-out (LIFO)</strong></i>.&nbsp; A <strong>Queue</strong> is<i><strong> first-in-first-out (FIFO)</strong></i>.&nbsp; A <strong>add()</strong> and<strong> remove()</strong> now served as the primary accessors.</li>
<li>Instead of deriving a <strong>FloatNode</strong> from the basic <strong>Node</strong> class, a <strong>CardNode</strong> was dervied from the generic <strong>Node</strong>.&nbsp; <strong>CardNode</strong> uses the <strong>Card</strong> class of <span style="color: #800080;"><strong><i>built in previous modules</i></strong></span>.</li>
<li>Instead of signaling a <strong>pop()</strong> error by returning a special value (<strong>STACK_EMPTY = Float.MIN_VALUE</strong>), a customized <strong>QueueEmptyException</strong> will be thrown within the <strong>remove()</strong> method. The client will catch it.</li>
<li>All instances of <strong>show()</strong> are replaced with the more professional <strong>toString()</strong>, and letting only the client send results to the display.</li>
</ol>
<h4>Picturing Queues</h4>
<p>The <strong>head</strong> member of <strong>Queue</strong> is the <i>first or oldest</i> <strong>Node</strong> in the queue, and it is the least recent one added.&nbsp; The <strong>tail</strong> will always point to the most recent one added to the end of the <strong>Queue</strong>.&nbsp; Say we have <i><strong>added</strong></i> <strong>Nodes N1, N2, N3</strong> and <strong>N4</strong>, in that order.&nbsp; The <strong>Nodes</strong> were linked (in the <strong>Queue</strong>) as follows:</p>
<div style="border: 1px solid; padding: 1px 4px 1px 4px;">The links of the <strong>next</strong> pointers look like the <strong>StackNode</strong> organization, with <strong>head </strong> and<strong> tail</strong> sharing the role of our old <strong>top</strong>:
<pre>   head → N1 → N2 → N3 → N4 → null
</pre>
<p><strong>&nbsp;</strong>The tail pointer, not shown above, points to N4</p>
<pre>  head → N1 → N2 → N3 → N4 ← tail
</pre>
</div>
<p>If we instantiated a new <strong>Node</strong> <strong>N5</strong>, and added it onto the <strong> Queue q,</strong> it would go in at the <strong>tail</strong>,&nbsp; Here is the <strong>Queue</strong>, <strong>q</strong>, after a <strong> q.Add(N5)</strong>;</p>
<div style="border: 1px solid; padding: 1px 4px 1px 4px;">A couple links have to be changed to result in:
<pre>  head → N1 → N2 → N3 → N4 → N5 → null
</pre>
<p><strong>&nbsp;</strong>Note: the <strong>tail</strong> has to be adjusted:</p>
<pre>  head → N1 → N2 → N3 → N4 → N5 ← tail
</pre>
</div>
<p>If we then <i><strong>removed</strong></i> an item from the <strong>Queue</strong>, using <strong> q.Remove()</strong>, the picture would be:</p>
<div style="border: 1px solid; padding: 1px 4px 1px 4px;">The links now convey the following:
<pre>  head → N2 → N3 → N4 → N5 → null</pre>
<p><strong>&nbsp;</strong>Note, the <strong>tail</strong> <i> may not </i>have to be adjusted (but in one case, not shown, it <i>will</i>):</p>
<pre>  head → N2 → N3 → N4 → N5 ← tail</pre>
</div>

<h3><u>Phase 1: Base Classes Node and Queue</u></h3>
<h4>Base Class Node</h4>
<p>This is the base class.&nbsp; However, I want you to give this class a different name.&nbsp; Call it <strong>Node</strong> (not <i>QueueNode</i> or <i>StackNode</i>, just <strong>Node</strong>).&nbsp;&nbsp; Its <strong>toString()</strong> methods with replace the previous<strong> show()</strong> method.</p>
<h4>Base Class Queue</h4>
<p>The <strong>Queue</strong> must accomplish the following: </p>
<ul>
<li><i><strong>add</strong></i> items to the <strong>Queue</strong> using <strong>add()</strong> not <strong> push()</strong>.&nbsp; <strong>push()</strong> does not appear in our <strong>Queue</strong> class.</li>
<li><i><strong>retrieve</strong></i> items from the <strong>Queue</strong> using <strong>remove()</strong> not <strong>pop()</strong>.&nbsp; <strong>pop()</strong> does not appear in our <strong>Queue</strong> class.</li>
<li>
<strong>remove()</strong> removes and returns the <i>oldest</i> item in the <strong>Queue</strong>.&nbsp; This is different from <strong>pop()</strong> which removed and returned the <i>youngest</i> item in the <strong>Queue</strong>.</li>
<li>
<strong>remove()</strong> throws a <strong>QueueEmptyException</strong>&nbsp; exception if the queue is empty.&nbsp; You will define this exception.</li>
<li>Provide a <strong>toString()</strong> method produces a <strong>String</strong> of all the items in the <strong>Queue</strong> from oldest to youngest.</li>
<li>Instead of one <strong>Node</strong> pointer member, <strong>top</strong>, you'll need two <strong>Node</strong> pointer members, and neither should be called <strong>top</strong> (since <strong>top</strong> is not meaningful in a <strong>Queue</strong>).&nbsp; Examples are <strong>head/tail</strong>, <strong>front/back</strong>, <strong>oldest/youngest</strong>, etc.&nbsp; Select two names and use them accordingly.</li>
</ul>
<h3><u>Phase 2: Intermediate Step - Check Your Base Classes</u></h3>
<p>A simple test case was designed to display some <strong>(generic node)</strong>s.&nbsp; The <strong>Queue's toString()</strong> method was also validated via simple loop in <strong>main()</strong> to remove and display nodes as they are removed.&nbsp;&nbsp; The output of these two techniques were compared.&nbsp; Additionally, the <strong>QueueEmptyException</strong> was tested to ensure the exception would be caught properly.</p>
<p><strong>add() </strong>and <strong>remove()</strong> will be slightly more complicated than <strong>push()</strong> and <strong>pop()</strong> in that they required <i>two</i> pointers, <strong>front</strong> and <strong>back</strong> (or <strong>head</strong> and <strong>tail</strong> to manage the nodes.&nbsp; </p>
<h3><u>Phase 3: Derived Classes CardNode and CardQueue</u></h3>
<h4>Deriving from Node</h4>
<p>This class is derived from <strong>Node</strong> and <strong>CardNode</strong>.&nbsp; It contains one additional member, just like the <strong>FloatNode</strong> did.&nbsp; However, instead of that additional member being a <strong>float</strong> it is a<strong>Card</strong>.&nbsp;</p>
<ul>
<li>The<strong>toString()</strong> method of this class overrides that of the generic <strong>Node</strong> class to return the specific type of data. &nbsp; As a result, the <strong>Card</strong> class stringize itself through its, already defined, <strong>toString()</strong> method.</li>
</ul>
<h4>Deriving from Queue</h4>
<p>The <strong>CardQueue</strong> was dervied from <strong>Queue</strong>. The methods within here allow the user to <i><strong>add</strong></i> actual&nbsp; <strong>Card</strong>s onto each of the <strong>Queue</strong>.&nbsp;</p>
<p>In the client, this functionality was tested by performing <strong>add()</strong> on a bunch of cards and then passing them to<strong>toString()</strong> so that the queue may be displayed on the screen. Similarly, <strong>remove()</strong> items were displayed for each method call.&nbsp; This was repeated till the <strong>remove()</strong> iterations exceed the cards in queue.</p>



